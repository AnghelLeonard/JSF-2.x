package my.artifacts;

import java.util.Random;

public final class PlayerHelper {

    public static String addPlayerRank(String name) {
        // look for player, or at least do something else
        Random rnd = new Random();
        if (rnd.nextInt(10) < 5) {
            return "Successfully added, " + name + "!";
        }
        return "Ooops! That player " + name + " exist in ATP ranking!";
    }
}
