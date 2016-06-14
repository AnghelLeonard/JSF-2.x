package beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class FooBean {

    @Inject
    Logger fooLog;

    public void logFooAction() {
        fooLog.info("Log message from FooBean !");
    }
}
