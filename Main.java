import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args)throws FileNotFoundException{
        
        int num = 0;
        if(args.length == 0){
            num = 1;
        }else{
            try
            {
                num = Integer.parseInt(args[0]);
            
            }catch(NumberFormatException ex)
            {
                    
            }
        }
        Simulator mySimulator = new Simulator(generateSimulation(num),new Logger());
        Result result = mySimulator.run();
        System.out.println(result.getFirstSixNames().toString());
    }
    
    public static Simulation generateSimulation(int round)throws FileNotFoundException {
        Race race = new Race();
        Track track = Track.createTrack();
        Pilot[] temp = track.getPilots();
        Simulation sim = new Simulation(temp);
        for(int i = 0; i<round; i++){
            Pilot[] raceRes = race.runRace();
            sim.generateData(sim.FirstSixNames(raceRes));
            sim.makeStatics(sim.load(), raceRes);
            sim.generateData(sim.getPilotArr());
        }

        return sim;
    }
}