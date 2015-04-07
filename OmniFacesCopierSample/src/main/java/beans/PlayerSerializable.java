package beans;

import java.io.Serializable;

public class PlayerSerializable implements Serializable {

    private String name;
    private String surname;
    private int rank;    

    public PlayerSerializable(){        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
