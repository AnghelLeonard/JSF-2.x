package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class PlayerBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(PlayerBean.class.getName());

    private String[] selectedPlayers;
    private ArrayList<Integer> selectedRanks;
    private ArrayList<Player> selectedPlayersList;

    private static final ArrayList<Integer> playersRanks;
    private static final ArrayList<Player> playersList;
    private static final Player[] playersArray;
    private static final Map<String, Object> playersMap;

    static {
        playersRanks = new ArrayList<>();
        playersRanks.add(1);
        playersRanks.add(2);
        playersRanks.add(3);
    }

    static {
        playersList = new ArrayList<>();
        playersList.add(new Player("Rafa", "Rafael Nadal"));
        playersList.add(new Player("Roger F", "Roger Federer"));
        playersList.add(new Player("Nole", "Novak Djokovic"));
    }

    static {
        playersArray = new Player[3];
        playersArray[0] = new Player("Rafa", "Rafael Nadal");
        playersArray[1] = new Player("Roger F", "Roger Federer");
        playersArray[2] = new Player("Nole", "Novak Djokovic");
    }

    static {
        playersMap = new LinkedHashMap<>();
        playersMap.put("Rafa", "Rafael Nadal"); //label, value
        playersMap.put("Roger F", "Roger Federer");
        playersMap.put("Nole", "Novak Djokovic");
    }

    public ArrayList<Integer> getPlayersRanks() {
        return playersRanks;
    }

    public Map<String, Object> getPlayersMap() {
        return playersMap;
    }

    public Player[] getPlayersArray() {
        return playersArray;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public String[] getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(String[] selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }

    public ArrayList<Integer> getSelectedRanks() {
        return selectedRanks;
    }

    public void setSelectedRanks(ArrayList<Integer> selectedRanks) {
        this.selectedRanks = selectedRanks;
    }

    public ArrayList<Player> getSelectedPlayersList() {
        return selectedPlayersList;
    }

    public void setSelectedPlayersList(ArrayList<Player> selectedPlayersList) {
        this.selectedPlayersList = selectedPlayersList;
    }

    public String selectedAction() {
        return "data";
    }

    public void selectedVCLAction(ValueChangeEvent event) {
        LOG.log(Level.INFO, "selectedVCLAction() called, {0}", ((Player)((ArrayList)event.getNewValue()).get(0)).getLabel());
    }
}
