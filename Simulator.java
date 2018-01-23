import java.util.Random;
import java.io.FileNotFoundException;

public class Simulator {
    Simulation simulation;
    Logger logger;

    public Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }
    public Result run()throws FileNotFoundException {
        Statictics stats = new Statictics(simulation.getPilotArr());
        return new Result(simulation.FirstSix(simulation.getPilotArr()), stats);

    }

    


}