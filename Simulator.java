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
        Race race = new Race();
        Simulation simul = new Simulation(race.runRace());
        Statictics stats = new Statictics(simul.getPilotArr());
        return new Result(race.FirstSix(simul.getPilotArr()), stats);

    }
}