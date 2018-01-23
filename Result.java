import java.util.HashSet;
import java.util.Set;

public class Result {
    Pilot[] firstSix;
    Statictics stats;

    public Result(Pilot firstSix, Statictics stats){
        this.firstSix = firstSix;
        this.stats = stats;
    }
    public getFirstSix(){
        return firstSix;
    }
    public getStats(){
        return stats;
    }
    public String[] getFirstSixNames() {
        String[] winnersName = new String[6];
        for(int i = 0; i < firstSix.length; i++) {
            winnersName[i] = firstSix[i].getName();
            
        }
        return winnersName;
    }
    
    public String[] getWinnerTeams() {
        String[] winnerTeams = new String[6];
        for(int i = 0; i < firstSix.length; i++) {
            winnerTeams[i] = (firstSix[i].getCar()).getTeamName();

    }
    Set<String> set = new HashSet<String>(winnerTeams);
    String[] asd = set.toArray(new String[set.size()]);
    return asd;
    }

}
