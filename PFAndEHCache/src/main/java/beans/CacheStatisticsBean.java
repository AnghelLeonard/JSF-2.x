package beans;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.omnifaces.cdi.Eager;

/**
 *
 * @author Anghel Leonard
 */
@Eager
@ApplicationScoped
public class CacheStatisticsBean {

    private static final Logger LOG = Logger.getLogger(CacheStatisticsBean.class.getName());
    private static final String CACHE_MANAGER = "net.sf.ehcache:type=CacheManager,name=__DEFAULT__";
    private static final String CACHE = "net.sf.ehcache:type=Cache,CacheManager=__DEFAULT__,name=myCache";
    private static final String CACHE_STATISTICS = "net.sf.ehcache:type=CacheStatistics,CacheManager=__DEFAULT__,name=myCache";
    private static final String CACHE_CONFIGURATION = "net.sf.ehcache:type=CacheConfiguration,CacheManager=__DEFAULT__,name=myCache";
    private static final ArrayList<ObjectName> objectNames = new ArrayList<ObjectName>() {
        {
            try {
                add(new ObjectName(CACHE_MANAGER));
                add(new ObjectName(CACHE));
                add(new ObjectName(CACHE_STATISTICS));
                add(new ObjectName(CACHE_CONFIGURATION));
            } catch (MalformedObjectNameException ex) {
                Logger.getLogger(CacheStatisticsBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    @PostConstruct
    public void init() {
        try {
            LOG.info("------------ Configure JConsole MBeans ------------");
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            LOG.info("----------------- Unregister MBeans ---------------");
            for (ObjectName name : objectNames) {
                if (mBeanServer.isRegistered(name)) {
                    mBeanServer.unregisterMBean(name);
                }
            }

            LOG.info("------------------ Register MBeans ----------------");
            CacheManager manager = CacheManager.create();
            ManagementService.registerMBeans(manager, mBeanServer, true, true, true, true);

            LOG.info("------------ ------------------------  ------------");
        } catch (NullPointerException | InstanceNotFoundException | MBeanRegistrationException ex) {
            Logger.getLogger(CacheStatisticsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
