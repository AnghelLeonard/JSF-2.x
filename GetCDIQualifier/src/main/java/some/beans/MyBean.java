package some.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyBean {

    private static final Logger LOG = Logger.getLogger(MyBean.class.getName());

    @Inject
    @ContextParam(name = "javax.faces.PROJECT_STAGE")
    private String projectStage;

    @Inject
    @ContextParam(name = "dummy")
    private String dummy;

    @Inject
    @ContextParam
    private String none;

    public void doSomething() {
        LOG.log(Level.INFO, "projectStage = {0}", projectStage);
        LOG.log(Level.INFO, "dummy = {0}", dummy); // null
        LOG.log(Level.INFO, "none = {0}", none); // CONTEXT_PARAM_NOT_FOUND
    }
}
