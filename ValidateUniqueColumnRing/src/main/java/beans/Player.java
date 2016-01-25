package beans;

import java.io.Serializable;

/**
 *
 * @author Anghel Leonard
 */
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    // more fields
    
    public Player(String name) {
        this.name = name;       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
