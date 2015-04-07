package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.copier.CloneCopier;
import org.omnifaces.util.copier.CopyCtorCopier;
import org.omnifaces.util.copier.NewInstanceCopier;
import org.omnifaces.util.copier.SerializationCopier;

@Named
@RequestScoped
public class CopierBean implements Serializable {

    private String test;
    private String pname;
    private String psurname;
    private int prank;

    public void cloneCopierTest() {

        CloneCopier cloneCopier = new CloneCopier();
        PlayerCloneable player_clone = (PlayerCloneable) cloneCopier.copy(createOriginalPlayerCloneable());

        this.pname = player_clone.getName();
        this.psurname = player_clone.getSurname();
        this.prank = player_clone.getRank();

        this.test = "Test CloneCopier";
    }

    public void serializationCopierTest() {

        SerializationCopier serializationCopier = new SerializationCopier();
        PlayerSerializable player_serializable = (PlayerSerializable) serializationCopier.copy(createOriginalPlayerSerializable());

        this.pname = player_serializable.getName();
        this.psurname = player_serializable.getSurname();
        this.prank = player_serializable.getRank();

        this.test = "Test SerializationCopier";
    }

    public void copyCtorCopierTest() {

        CopyCtorCopier copyCtorCopier = new CopyCtorCopier();
        PlayerCopyCtor player_copyctor = (PlayerCopyCtor) copyCtorCopier.copy(createOriginalPlayerCopyCtor());

        this.pname = player_copyctor.getName();
        this.psurname = player_copyctor.getSurname();
        this.prank = player_copyctor.getRank();

        this.test = "Test CopyCtorCopier";
    }

    public void newInstanceCopierTest() {

        NewInstanceCopier newInstanceCopier = new NewInstanceCopier();
        PlayerNewInstance player_newinstance = (PlayerNewInstance) newInstanceCopier.copy(createOriginalPlayerNewInstance());

        this.pname = player_newinstance.getName();
        this.psurname = player_newinstance.getSurname();
        this.prank = player_newinstance.getRank();

        this.test = "Test NewInstanceCopier";
    }
   
    private PlayerCloneable createOriginalPlayerCloneable() {
        PlayerCloneable player = new PlayerCloneable();
        player.setName("Rafael");
        player.setSurname("Nadal");
        player.setRank(1);

        return player;
    }

    private PlayerSerializable createOriginalPlayerSerializable() {
        PlayerSerializable player = new PlayerSerializable();
        player.setName("Roger");
        player.setSurname("Federer");
        player.setRank(2);

        return player;
    }

    private PlayerCopyCtor createOriginalPlayerCopyCtor() {
        PlayerCopyCtor player = new PlayerCopyCtor();
        player.setName("David");
        player.setSurname("Ferrer");
        player.setRank(3);

        return player;
    }

    private PlayerNewInstance createOriginalPlayerNewInstance() {
        PlayerNewInstance player = new PlayerNewInstance();
        player.setName("Novak");
        player.setSurname("Djokovic");
        player.setRank(4);

        return player;
    }

    public String getPname() {
        return pname;
    }

    public String getPsurname() {
        return psurname;
    }

    public int getPrank() {
        return prank;
    }

    public String getTest() {
        return test;
    }
}
