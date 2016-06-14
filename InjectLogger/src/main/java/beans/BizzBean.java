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
public class BizzBean {

    @Inject
    Logger bizzLog;

    public void logBizzAction() {
        bizzLog.info("Log message from BizzBean !");
    }
}
