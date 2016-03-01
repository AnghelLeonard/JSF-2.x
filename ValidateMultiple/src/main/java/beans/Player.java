package beans;

import java.io.Serializable;

/**
 *
 * @author Anghel Leonard
 */
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private int rank;
    private String name;

    public Player(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }        

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" + "rank=" + rank + ", name=" + name + '}';
    }        
}
