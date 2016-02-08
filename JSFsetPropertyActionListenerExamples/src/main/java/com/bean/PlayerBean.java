package com.bean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlayerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String playerName = "Rafael Nadal";
    private Player player;

    public PlayerBean() {
        player = new Player();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {        
        this.playerName = playerName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void action(){
        System.out.println("Name set: " + playerName);
    }

}
