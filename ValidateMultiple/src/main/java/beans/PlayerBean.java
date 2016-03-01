package beans;

import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Anghel Leonard
 */
@Named
@ViewScoped
public class PlayerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Player> players;
    private List<Player> selectedviaCheckbox;
    private DualListModel<Player> model;

    @PostConstruct
    public void init() {
        selectedviaCheckbox = new ArrayList<>();
        players = asList(
                new Player(8, "Tomas Berdych"),
                new Player(20, "Jurgen Melzer"),
                new Player(10, "Richard Gasquet"),
                new Player(4, "Rafael Nadal"),
                new Player(23, "Jack Sock"),
                new Player(36, "Pablo Cuevas"),
                new Player(1, "Fernando Verdasco"),
                new Player(19, "Dominic Thiem"),
                new Player(29, "Jeremy Chardy"),
                new Player(38, "Borna Coric")
        );

        model = new DualListModel<>(
                new ArrayList<>(players),
                new ArrayList<Player>()
        );
    }

    public List<Player> getPlayers() {
        return players;
    }

    public DualListModel<Player> getModel() {
        return model;
    }

    public void setModel(DualListModel<Player> model) {
        this.model = model;
    }   

    public List<Player> getSelectedviaCheckbox() {
        return selectedviaCheckbox;
    }

    public void setSelectedviaCheckbox(List<Player> selectedviaCheckbox) {
        this.selectedviaCheckbox = selectedviaCheckbox;
    }        
    
    public void playersAction(){
        Messages.addGlobalInfo("The selected players are valid");
    } 
}
