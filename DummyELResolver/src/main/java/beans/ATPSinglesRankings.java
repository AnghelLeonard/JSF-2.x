package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anghel Leonard
 */
public class ATPSinglesRankings {
    
    public static List<String> getSinglesRankings(){
       
        List<String> atp_ranking= new ArrayList<>();
        
        atp_ranking.add("1 Nadal, Rafael (ESP)");
        atp_ranking.add("2 Djokovic, Novak (SRB)");
        atp_ranking.add("3 Ferrer, David (ESP)");
        atp_ranking.add("4 Murray, Andy (GBR)");
        atp_ranking.add("5 Del Potro, Juan Martin (ARG)");                
        
        return atp_ranking;
    }
}
