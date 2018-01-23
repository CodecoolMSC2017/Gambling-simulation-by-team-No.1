import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args)throws FileNotFoundException{
    Race race = new Race();
    Pilot[] raceResult = race.runRace();
    Simulation simulation = new Simulation();
    Pilot[] returnedPilots = simulation.load();
    for(Pilot pilot : returnedPilots){
        System.out.println(pilot.getName()+" " +pilot.getPenalties());
    }
    System.out.println("\n");
    Pilot[] finalResult =simulation.makeStatics(returnedPilots, raceResult);
    for(Pilot pilot : raceResult){
        System.out.println(pilot.getName()+" " +pilot.getPenalties());
    }
    System.out.println("\n");
    for(Pilot pilot : finalResult){
        System.out.println(pilot.getName()+" " +pilot.getPenalties());
    }
    simulation.generateData(finalResult);
    
    }
}