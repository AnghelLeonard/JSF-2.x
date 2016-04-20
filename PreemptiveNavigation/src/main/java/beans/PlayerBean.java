package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayerBean {

    private static final Logger logger = Logger.getLogger(PlayerBean.class.getName());
    private String player;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String playerDone() {
        logger.log(Level.INFO, "playerDone method called ...");
        player = "Rafael Nadal";
        return "done";
    }
}
