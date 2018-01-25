import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.System;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        Logger logger = new Logger();
        Simulation simulation = new Simulation(Track.createTrack().getPilots());
        simulation.reset();
        logger.clearScreen();
        int num = 0;
        if(args.length == 0){
            logger.basicPrinter("Please enter a number: ");
            Scanner scStart = new Scanner(System.in);
            String input = scStart.nextLine();
            num = Integer.parseInt(input);
            
            
        }else{
            try
            {
                num = Integer.parseInt(args[0]);
            
            }catch(NumberFormatException ex)
            {
                    
            }
        }

        final long startTime = System.nanoTime();
        Simulator mySimulator = new Simulator(generateSimulation(num),new Logger(),num);
        Result result = mySimulator.run();
        final double duration = (System.nanoTime() - startTime)/1000000000.0;
        String mystr =String.format("%.2f", duration) +" s";
        logger.Log("Running time:", mystr);
        menus(mySimulator, result);
    }
    
    public static void menus(Simulator simulator, Result result) throws FileNotFoundException {
        Logger logger = new Logger();
        
        while(true){    
            logger.printMenu();
            Scanner sc = new Scanner(System.in);
            String inputMenu = sc.nextLine();
            

            if(inputMenu.equals(":winners")){
                logger.clearScreen();
                logger.StrArrPrinter("Best chance to the first six place :",simulator.simulation.getBest());
            } else if(inputMenu.equals(":funfacts")) {
                logger.clearScreen();
                logger.basicPrinter("Total penalties: " + Integer.toString(result.getSumOfPenalties()) + "\n");
                logger.basicPrinter("Average points per simulation: "+ Double.toString(result.getAverageOfPoints()) + "\n");
                logger.basicPrinter("Average speed per simulation: " + Double.toString(result.getAverageSpeed()) + "\n");
            } else if(inputMenu.equals(":stats")) {
                logger.clearScreen();
                logger.basicPrinter("First six based on all simulation: " + result.getFirstSixNames() + "\n");
                logger.StrArrPrinter("Names of the winner teams: ",result.getWinnerTeams());
            } else if(inputMenu.equals(":exit")) {
                sc.close();
                System.exit(0);
            }
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