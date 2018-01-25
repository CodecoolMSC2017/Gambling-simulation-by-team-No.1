import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.System;
import java.util.Date;

public class Main {

    public static void main(String[] args)throws FileNotFoundException{
        final long startTime = System.nanoTime();
        Logger logger = new Logger();
        Simulation simulation = new Simulation(Track.createTrack().getPilots());
        simulation.reset();
        logger.clearScreen();
        int num = 0;
        if(args.length == 0){
            menus();
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
        final double duration = (System.nanoTime() - startTime)/1000000000.0;
        String mystr =String.format("%.2f", duration) +" s";
        logger.Log("Running time:", mystr);
    }
    
    public static void menus() {
        Logger logger = new Logger();
        logger.printMenu();
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        sc.close();

        if(input.equals(":winners")){
            logger.basicPrinter("Winners coming soon\n");
        } else if(input.equals(":funfacts")) {
            logger.basicPrinter("Fun facts coming soon!\n");
        } else if(input.equals(":stats")) {
            logger.basicPrinter("Statistics coming soon!\n");;
        } else if(input.equals(":exit")) {
            System.exit(0);
        }
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