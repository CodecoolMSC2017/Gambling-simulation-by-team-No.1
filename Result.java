import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

public class Result {
    Pilot[] firstSix;
    Statictics stats;

    public Result(Pilot[] firstSix, Statictics stats){
        this.firstSix = firstSix;
        this.stats = stats;
    }
    public Pilot[] getFirstSix(){
        return firstSix;
    }
    public Statictics getStats(){
        return stats;
    }
    public String getFirstSixNames() {
        String winnersName= "";
        for(int i =0;i<firstSix.length;i++) {
            winnersName += firstSix[i].getName();
            if (i !=firstSix.length-1){
                winnersName += "; ";
            }
            
        }
        return winnersName;
    }
    
    public String[] getWinnerTeams() {
        String[] winnerTeams = new String[6];
        for(int i = 0; i < firstSix.length; i++) {
            winnerTeams[i] = (firstSix[i].getCar()).getTeamName();

        }
        Set<String> set = new HashSet<>(Arrays.asList(winnerTeams));
        String[] asd = set.toArray(new String[set.size()]);
        return asd;
    }
    
    public int getSumOfPenalties() {
        return stats.sumOfPenalties;
    }

    public double getAverageOfPoints() {
        return stats.averageOfPoints;
    }

    public double getAverageSpeed() {
        return stats.averageSpeed;
    }

    public double getAvgPenalties() {
        return stats.avgPenaltiesPerPilot();
    }
}
