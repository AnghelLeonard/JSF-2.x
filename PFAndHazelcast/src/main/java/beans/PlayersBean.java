package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.cache.HazelcastCacheProvider;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Anghel Leonard
 */
@Named
@SessionScoped
public class PlayersBean implements Serializable {

    List<Player> data = new ArrayList<>();

    @PostConstruct
    public void PlayersBean() {
        data.add(new Player("NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia", "Monte Carlo, Monaco", (short) 188, (byte) 80));
        data.add(new Player("RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain", "Manacor, Mallorca, Spain", (short) 185, (byte) 85));
        data.add(new Player("TOMAS BERDYCH", (byte) 28, "Valasske Mezirici, Czech", "Monte Carlo, Monaco", (short) 196, (byte) 91));
        data.add(new Player("STANISLAS WAWRINKA", (byte) 28, "Lausanne, Switzerland", "St. Barthelemy, Switzerland", (short) 183, (byte) 81));
        data.add(new Player("ANDY MURRAY", (byte) 26, "Dunblane, Scotland", "London, England", (short) 190, (byte) 84));
        data.add(new Player("JUAN MARTIN DEL POTRO", (byte) 25, "Tandil, Argentina", "Tandil, Argentina", (short) 198, (byte) 97));
        data.add(new Player("JO-WILFRIED TSONGA", (byte) 28, "Le Mans, France", "Gingins, Switzerland", (short) 188, (byte) 91));
        data.add(new Player("ROGER FEDERER", (byte) 32, "Basel, Switzerland", "Bottmingen, Switzerland", (short) 185, (byte) 85));
        data.add(new Player("RICHARD GASQUET", (byte) 27, "Beziers, France", "Neuchatel, Switzerland", (short) 185, (byte) 75));
        data.add(new Player("DAVID FERRER", (byte) 31, "Javea, Spain", "Valencia, Spain", (short) 175, (byte) 73));
    }

    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }

    public Object showCache() {
        HazelcastCacheProvider cacheProvider = (HazelcastCacheProvider) RequestContext.getCurrentInstance().getApplicationContext().getCacheProvider();
        return cacheProvider.get("myCache", "myTable");
    }

    public void clearCache() {
        HazelcastCacheProvider cacheProvider = (HazelcastCacheProvider) RequestContext.getCurrentInstance().getApplicationContext().getCacheProvider();
        cacheProvider.remove("myCache", "myTable");
    }
}
