package beans;

public class PlayerCopyCtor {

    private String name;
    private String surname;
    private int rank;

    public PlayerCopyCtor() {
    }

    public PlayerCopyCtor(PlayerCopyCtor playerCopyCtor) {
        this.name = playerCopyCtor.getName();
        this.surname = playerCopyCtor.getSurname();
        this.rank = playerCopyCtor.getRank();
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
