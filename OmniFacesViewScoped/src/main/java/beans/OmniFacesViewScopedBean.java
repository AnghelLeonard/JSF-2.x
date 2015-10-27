package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

@Named(value="omnifacesViewScoped")
@ViewScoped
public class OmniFacesViewScopedBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(OmniFacesViewScopedBean.class.getName());

    public OmniFacesViewScopedBean() {
    }
    
    @PostConstruct
    public void init(){
        LOG.info("OmniFacesViewScopedBean#init() invoked ...");
    }
    
    public void action() {
        LOG.info("OmniFacesViewScopedBean#action() invoked ...");
    }

    @PreDestroy
    public void destroy() {
        LOG.info("OmniFacesViewScopedBean#destroy() invoked ...");
    }

}
