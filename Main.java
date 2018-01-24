import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.System;

public class Main {
    public static void main(String[] args)throws FileNotFoundException{
        Logger.clearScreen();
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
    }
    
    public static void menus() {
        
        Logger.printMenu();
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

        if(input.equals(":winners")){
            Logger.basicPrinter("Winners coming soon\n");
        } else if(input.equals(":funfacts")) {
            Logger.basicPrinter("Fun facts coming soon!\n");
        } else if(input.equals(":stats")) {
            Logger.basicPrinter("Statistics coming soon!\n");;
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