package beans;

import java.util.Random;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class TheBean {

    private static final Logger LOG = Logger.getLogger(TheBean.class.getName());

    private int rnd = new Random().nextInt(100);

    public int getRnd() {
        return rnd;
    }

    public String theActionWithDoneOutcome() {
        LOG.info("TheBean#theActionWithDoneOutcome() called ...");
        return rnd > 50 ? "success" : "failure";
    }
    
    public String theActionWithDoneOutcomeAndRedirect() {
        LOG.info("TheBean#theActionWithDoneOutcome() called ...");
        return rnd > 50 ? "success?faces-redirect=true" : "failure?faces-redirect=true";
    }
}
