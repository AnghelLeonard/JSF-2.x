package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());
    private boolean rememberme = true;
    private boolean terms;

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }        

    public boolean isRememberme() {
        return rememberme;
    }

    public void setRememberme(boolean rememberme) {
        this.rememberme = rememberme;
    }

    public void rememberAction(ValueChangeEvent event) {
        LOG.log(Level.INFO, "rememberAction() called, {0}", event.getOldValue() + " - " + event.getNewValue());
    }

    public String termsAction(){
        return "data";
    }
}
