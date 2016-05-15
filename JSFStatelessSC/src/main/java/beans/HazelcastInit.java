package beans;

import com.hazelcast.config.Config;
import com.hazelcast.config.ListConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import org.omnifaces.cdi.Eager;

/**
 *
 * @author Anghel Leonard
 */
@Eager(requestURI = "/faces/start.xhtml")
@RequestScoped
public class HazelcastInit {

    @Resource(name = "payara/Hazelcast")
    HazelcastInstance hazelcast;

    private static final Logger LOG = Logger.getLogger(HazelcastInit.class.getName());

    @PostConstruct
    public void init() {
        LOG.info("Initialize list of products started ...");

        Config config = new XmlConfigBuilder().build();
        ListConfig listConfig = config.getListConfig("cart");
        listConfig.setName("cart");
        hazelcast.getConfig().addListConfig(listConfig);
        
        IList<Item> cartList = hazelcast.getList("cart");
        cartList.add(new Item("Dummy Product", 0));
       
        LOG.info("Initialize list of products successfully done ...");
    }

}
