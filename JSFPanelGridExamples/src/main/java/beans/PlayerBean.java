package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class PlayerBean {

    private final List<Player> players;
    private final Date today;

    public PlayerBean() {
        today = new Date();
        players = new ArrayList<>();
        players.add(new Player(1, "Serena Williams", "United States", "26 Sep 1981", 11285, 15));
        players.add(new Player(2, "Simona Halep", "Romania", "27 Sep 1991", 6580, 18));
        players.add(new Player(3, "Maria Sharapova", "Russia", "19 Apr 1987", 4691, 17));
        players.add(new Player(4, "Garbine Muguruza", "Spain", "08 Oct 1993", 4690, 20));
        players.add(new Player(5, "Petra Kvitova", "Czech Republic", "08 Mar 1990", 3860, 19));
        players.add(new Player(6, "Agnieszka Radwanska", "Poland", "06 Mar 1989", 3515, 23));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Date getToday() {
        return today;
    }

}
