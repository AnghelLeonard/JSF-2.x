package resolver;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.cdi.Eager;
import org.omnifaces.util.Messages;

// or use @Startup
@Eager
@ApplicationScoped
public class SetMessagesResolver {

    private static final Logger LOG = Logger.getLogger(SetMessagesResolver.class.getName());

    @PostConstruct
    public void init() {
        LOG.info("SETTING THE MAP FORMAT RESOLVER ...");
        Messages.setResolver(new MapFormatResolver());        
    }

}
