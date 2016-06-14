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
public class BuzzBean {

    @Inject
    Logger buzzLog;

    public void logBuzzAction() {
        buzzLog.info("Log message from BuzzBean !");
    }
}
