package sorting.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlayerBean implements Serializable {
    
    List<Player> data = new ArrayList<>();
    // this is not thread-safe, don't use it in production
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); 

    public PlayerBean() {
        try {
            data.add(new Player(2, "NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia", "Monte Carlo, Monaco", (short) 188, (byte) 80, "Boris Becker, Marian Vajda", sdf.parse("22.05.1987")));
            data.add(new Player(1, "RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain", (short) 185, (byte) 85, "Toni Nadal", sdf.parse("03.06.1986")));
            data.add(new Player(7, "TOMAS BERDYCH", (byte) 28, "Valasske Mezirici, Czech", "Monte Carlo, Monaco", (short) 196, (byte) 91, "Tomas Krupa", sdf.parse("17.09.1985")));
            data.add(new Player(8, "STANISLAS WAWRINKA", (byte) 28, "Lausanne, Switzerland", "St. Barthelemy, Switzerland", (short) 183, (byte) 81, "Magnus Norman", sdf.parse("28.03.1985")));
            data.add(new Player(4, "ANDY MURRAY", (byte) 26, "Dunblane, Scotland", "London, England", (short) 190, (byte) 84, "Ivan Lendl", sdf.parse("15.05.1987")));
            data.add(new Player(5, "JUAN MARTIN DEL POTRO", (byte) 25, "Tandil, Argentina", "Tandil, Argentina", (short) 198, (byte) 97, "Franco Davin", sdf.parse("23.09.1988")));
            data.add(new Player(10, "JO-WILFRIED TSONGA", (byte) 28, "Le Mans, France", "Gingins, Switzerland", (short) 188, (byte) 91, "Nicolas Escude & Thierry Ascione", sdf.parse("17.04.1985")));
            data.add(new Player(6, "ROGER FEDERER", (byte) 32, "Basel, Switzerland", "Bottmingen, Switzerland", (short) 185, (byte) 85, "Stefan Edberg, Severin Luthi", sdf.parse("08.08.1981")));
            data.add(new Player(9, "RICHARD GASQUET", (byte) 27, "Beziers, France", "Neuchatel, Switzerland", (short) 185, (byte) 75, "Sergi Bruguera and Sebastien", sdf.parse("18.06.1986")));
            data.add(new Player(3, "DAVID FERRER", (byte) 31, "Javea, Spain", "Valencia, Spain", (short) 175, (byte) 73, "Jose Francisco Altur", sdf.parse("02.04.1982")));
        
        } catch (java.text.ParseException ex) {
            Logger.getLogger(PlayerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }

    public String sortDataByRanking(final int dir) {

        Collections.sort(data, new Comparator<Player>() {
            @Override
            public int compare(Player key_1, Player key_2) {
                return dir * (key_1.getRanking() - key_2.getRanking());
            }
        });
        return null;
    }

    public String sortDataByName(final String dir) {

        Collections.sort(data, new Comparator<Player>() {
            @Override
            public int compare(Player key_1, Player key_2) {
                if (dir.equals("asc")) {
                    return key_1.getPlayer().compareTo(key_2.getPlayer());
                } else {
                    return key_2.getPlayer().compareTo(key_1.getPlayer());
                }
            }
        });
        return null;
    }
    
    public String sortDataByDate(final String dir) {

        Collections.sort(data, new Comparator<Player>() {
            @Override
            public int compare(Player key_1, Player key_2) {
                if (dir.equals("asc")) {
                    return key_1.getBorn().compareTo(key_2.getBorn());
                } else {
                    return key_2.getBorn().compareTo(key_1.getBorn());
                }
            }
        });
        return null;
    }
}

