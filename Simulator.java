import java.util.Random;

import java.io.FileNotFoundException;

public class Simulator {
    Simulation simulation;
    Logger logger;
    int round;

    public Simulator(Simulation simulation, Logger logger, int round) {
        this.simulation = simulation;
        this.logger = logger;
        this.round = round;
    }
    public Result run()throws FileNotFoundException {
        Statictics stats = new Statictics(simulation.getPilotArr(), round);
        return new Result(simulation.FirstSix(simulation.getPilotArr()), stats);

    }
    

    


}