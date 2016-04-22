package beans;

/**
 *
 * @author Anghel Leonard
 */
public class Player {
    
    private String player;
    private byte age;
    private String birthplace;
    private String residence;
    private short height;
    private byte weight;   

    public Player() {
    }
    
    public Player(String player, byte age, String birthplace, String residence, short height, byte weight) {        
        this.player = player;
        this.age = age;
        this.birthplace = birthplace;
        this.residence = residence;
        this.height = height;
        this.weight = weight;       
    }        

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }   

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }    
}