package beans;

import java.util.Objects;

public class Player {

    private int rank;
    private String name;
    private String country;
    private String dateOfBirth;
    private int points;
    private int tournaments;

    public Player() {
    }

    public Player(int rank, String playerName, String country, String dateOfBirth, int points, int tournaments) {
        this.rank = rank;
        this.name = playerName;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.points = points;
        this.tournaments = tournaments;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTournaments() {
        return tournaments;
    }

    public void setTournaments(int tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.rank;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.country);
        hash = 79 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 79 * hash + this.points;
        hash = 79 * hash + this.tournaments;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (this.points != other.points) {
            return false;
        }
        return this.tournaments == other.tournaments;
    }

}
