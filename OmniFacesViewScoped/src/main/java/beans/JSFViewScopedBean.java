package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value="jsfViewScoped")
@ViewScoped
public class JSFViewScopedBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(JSFViewScopedBean.class.getName());

    public JSFViewScopedBean() {
    }
    
    @PostConstruct
    public void init(){
        LOG.info("JSFViewScopedBean#init() invoked ...");
    }

    public void action() {
        LOG.info("JSFViewScopedBean#action() invoked ...");
    }

    @PreDestroy
    public void destroy() {
        LOG.info("JSFViewScopedBean#destroy() invoked ...");
    }

}
