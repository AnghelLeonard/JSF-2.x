package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private List<String> players = new ArrayList<>();
    private String player;

    public PlayerBean() {
        players.add("Rafael Nadal");
        players.add("Novak Djokovic");
        players.add("Roger Federer");
        players.add("Andy Murray");
        players.add("David Ferrer");
    }

    public void playerChangeValueMethod(ValueChangeEvent e) {
        System.out.println("PlayerBean: [PLAYER CHANGE]" + "  " + e.getOldValue() + " IN " + e.getNewValue());
    }
    
    public void playerChangeValueMethod(AjaxBehaviorEvent e) {
        System.out.println("PlayerBean: [PLAYER CHANGE]" + "  " + player);
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
