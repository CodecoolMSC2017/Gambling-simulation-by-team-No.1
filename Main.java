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
                logger.StrArrPrinter("Best chance to the first six place: ",simulator.simulation.getBest());
            } else if(inputMenu.equals(":funfacts")) {
                logger.clearScreen();
                logger.Log("\nTotal penalties:\n","\t" +  Integer.toString(result.getSumOfPenalties()));
                logger.Log("\nAverage penalties (per pilot):\n","\t" +  Double.toString(result.getAvgPenalties()));
                logger.Log("\nAverage points per simulation:\n" , "\t" + Double.toString(result.getAverageOfPoints()));
                logger.Log("\nAverage speed per simulation:\n" , "\t" +  Double.toString(result.getAverageSpeed()));
            } else if(inputMenu.equals(":stats")) {
                logger.clearScreen();
                logger.Log("\nFirst six based on all simulation\n " , "\t" + result.getFirstSixNames());
                logger.StrArrPrinter("\nNationality of the winners:",result.getWinnerNationalities());
                logger.StrArrPrinter("\nNames of the winner teams:",result.getWinnerTeams());
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