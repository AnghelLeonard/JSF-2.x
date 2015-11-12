package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

@Named(value = "dsViewScoped")
@ViewAccessScoped
public class DSViewScopedBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(DSViewScopedBean.class.getName());

    private final String done;

    public DSViewScopedBean() {
        done = "Done!";
    }

    @PostConstruct
    public void init() {
        LOG.info("DSViewScopedBean#init() invoked ...");
    }

    // forward to the same view
    public void action() {
        LOG.info("DSViewScopedBean#action() invoked ...");
    }

    // forward to the done_static.xhtml page
    public String actionStaticOutcome() {
        LOG.info("DSViewScopedBean#actionStaticOutcome() invoked ...");
        return "done_static";
    }

    // forward to the done_dynamic.xhtml page
    public String actionDynamicOutcome() {
        LOG.info("DSViewScopedBean#actionDynamicOutcome() invoked ...");
        return "done_dynamic";
    }
    
    // redirect to the done_static.xhtml page
    public String actionRedirectStaticOutcome() {
        LOG.info("DSViewScopedBean#actionRedirectStaticOutcome() invoked ...");
        return "done_static?faces-redirect=true;";
    }

    // redirect to the done_dynamic.xhtml page
    public String actionRedirectDynamicOutcome() {
        LOG.info("DSViewScopedBean#actionRedirectDynamicOutcome() invoked ...");
        return "done_dynamic?faces-redirect=true;";
    }

    @PreDestroy
    public void destroy() {
        LOG.info("DSViewScopedBean#destroy() invoked ...");
    }

    public String getDone() {
        return done;
    }
}
