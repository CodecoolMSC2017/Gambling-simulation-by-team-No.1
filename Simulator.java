import java.util.Random;

public class Simulator {
    Simulation simulation;
    Logger logger;

    public Simulator(Simulation simulation, Logger logger) {
        this.simulation = simulation;
        this.logger = logger;
    }

    public Result run() {
        Track track = Track.createTrack();
        Pilots[] myPilots = track.getPilots();
        for (Pilot pilot : myPilots) {
            basicScore(pilot);
            randomEvents(pilot);
        }

    }

    public void basicScore(Pilot pilot) {
        pilot.setPoint((pilot.getXp() * 2 + pilot.car.getTopSpeed()) / 2);
    }

    public String randomEvents(Pilot pilot) {
        Random random = new Random();
        int randomPercent = random.nextInt(pilot.getXp() / 5) + 1;
        if (randomPercent <= 4) {
            int randomEventPercent = random.nextInt(6);
            if (randomEventPercent == 1) {
                pilot.setPoints(0);
                return pilot.getName() + " distanced from the race.";
            } else if (randomEventPercent <= 3) {
                pilot.setPoints(pilot.getPoints - 20);
                return pilot.getName() + " got a drive-through penalty.";
            } else {
                pilot.setPoint(pilot.getPoint() - 30);
                return pilot.getName() + " got a stop-and-go penalty.";
            }
        }
        return null;

    }

}