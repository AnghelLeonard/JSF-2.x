package beans;

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

    public String theActionWithDoneOutcome() {
        LOG.info("TheBean#theActionWithDoneOutcome() called ...");
        return "done";
    }
    
    public String theActionWithOutcomeForSuccess() {
        LOG.info("TheBean#theActionWithOutcomeForSuccess() called ...");
        return "doneFromTheActionWithOutcome";
    }
    
    public String theActionWithOutcomeForFailure() {
        LOG.info("TheBean#theActionWithOutcomeForFailure() called ...");
        return "doneFromTheActionWithOutcome";
    }    
    
    public String theActionWithRedirectForSuccess() {
        LOG.info("TheBean#theActionWithRedirectForSuccess() called ...");
        return "doneFromTheActionWithRedirect";
    }
    
    public String theActionWithRedirectForFailure() {
        LOG.info("TheBean#theActionWithRedirectForFailure() called ...");
        return "doneFromTheActionWithRedirect";
    } 
}
