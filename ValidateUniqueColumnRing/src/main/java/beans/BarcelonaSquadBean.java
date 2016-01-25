package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Leonard
 */
@Named
@ViewScoped
public class BarcelonaSquadBean implements Serializable {
    
     private static final long serialVersionUID = 1L;

    private List<Player> players;
    
    @PostConstruct
    public void init() {       
        players = new ArrayList<>();
        players.add(new Player("Valdes"));
        players.add(new Player("Alves"));
        players.add(new Player("Pique"));
        players.add(new Player("Puyol"));
        players.add(new Player("Abidal"));
        players.add(new Player("Xavi"));                
        players.add(new Player("Busquets"));
        players.add(new Player("Iniesta"));
        players.add(new Player("Pedro"));
        players.add(new Player("Messi"));
        players.add(new Player("Villa"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public void someAction(){
        Messages.addGlobalInfo("The team was successfully updated!");
    }
}