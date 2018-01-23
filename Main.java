import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args)throws FileNotFoundException{
    Race race = new Race();
    Pilot[] raceResult = race.runRace();
    for(Pilot pilot : raceResult){
        System.out.println(pilot.getName()+" " +pilot.getPenalties());
    }
    Simulation simulation = new Simulation();
    simulation.generateData(raceResult);
    Pilot[] returnedPilots = simulation.load();
    for(Pilot pilot : returnedPilots){
        System.out.println(pilot.getName()+" " +pilot.getPenalties());
    }

    
    }
}