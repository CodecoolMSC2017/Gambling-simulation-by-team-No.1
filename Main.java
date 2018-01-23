import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args)throws FileNotFoundException{
    Race race = new Race();
    String[] raceResult = race.runRace();
    for(String name : raceResult){
        System.out.println(name);
    }
    
    }
}