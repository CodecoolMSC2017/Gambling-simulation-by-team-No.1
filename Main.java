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
        generateSimulation(num);  
    }
    
    public static Simulation generateSimulation(int round)throws FileNotFoundException {
        Race race = new Race();
        Pilot[] temp = new Pilot[]{};
        Simulation sim = new Simulation(temp);
        for(int i = 0; i<round + 1; i++){
            Pilot[] raceRes = ((sim.run()).getStats()).getResult();
            sim.makeStatics(sim.load(), raceRes);
            sim.generateData(sim.getPilotArr());
        }

        return sim;
    }
}