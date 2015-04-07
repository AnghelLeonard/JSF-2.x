package beans;

public class PlayerCloneable implements Cloneable {

    private String name;
    private String surname;
    private int rank;

    public PlayerCloneable(){        
    }
    
    // This method calls Object's clone().
    PlayerCloneable getClone() throws CloneNotSupportedException {
        // call clone in Object.
        return (PlayerCloneable) super.clone();
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
