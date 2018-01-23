import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args)throws FileNotFoundException{
        //Integer.parseInt(args[0])
        if(args.length == 0){
            generateSimulation(1);
        }
        try
        {
            generateSimulation(Integer.parseInt(args[0]));
        }catch(NumberFormatException ex)
        {
                
        }
        
    
    }
    public static Simulation generateSimulation(int round)throws FileNotFoundException {
        Race race = new Race();
        Simulation sim = new Simulation(race.runRace());
        for(int i = 0; i<round+1; i++){
            Pilot[] raceRes = race.runRace();
            sim.makeStatics(sim.load(), raceRes);
            sim.generateData(sim.getPilotArr());
        }
        return sim;
    }
}