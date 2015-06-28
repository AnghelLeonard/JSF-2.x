package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CommandBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(CommandBean.class.getName());

    private static final long serialVersionUID = 1L;

    public void save(AjaxBehaviorEvent evt) {
        LOG.log(Level.INFO, "---------------------------Saving---------------------------- / {0}", evt);
    }

}
