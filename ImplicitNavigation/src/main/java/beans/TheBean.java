package beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class TheBean {

    private static final Logger LOG = Logger.getLogger(TheBean.class.getName());

    public void theActionWithVoid() {
        LOG.info("TheBean#theActionWithVoid() called ...");
    }

    public String theActionWithViewID() {
        LOG.info("TheBean#theActionWithViewID() called ...");
        return "success.xhtml";
    }

    public String theActionWithExternalURL() {
        LOG.info("TheBean#theActionWithExternalURL() called ...");
        return "http://showcase.omnifaces.org/";
    }

    public String theActionWithOutcome() {
        LOG.info("TheBean#theActionWithOutcome() called ...");
        return "success";
    }

    public String theActionWithRedirect() {
        LOG.info("TheBean#theActionWithRedirect() called ...");
        return "success?faces-redirect=true;";
    }
}
