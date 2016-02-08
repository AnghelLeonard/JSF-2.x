package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TournamentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Player registeredPlayer;

    private Player selectedPlayer;
    private List<Player> players;

    public TournamentBean() {
        registeredPlayer = new Player();

        selectedPlayer = new Player();
        players = new ArrayList<>(Arrays.asList(new Player("Rafael Nadal"), new Player("Novak Djokovic"),
                new Player("Roger Federer"), new Player("Andy Murray"), new Player("David Ferrer")));
    }

    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    public void setRegisteredPlayer(Player registeredPlayer) {
        this.registeredPlayer = registeredPlayer;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void removePlayer() {
        players.remove(selectedPlayer);
        System.out.println("Removed " + selectedPlayer);
    }

}
