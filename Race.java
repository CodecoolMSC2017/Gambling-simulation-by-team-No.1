import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Race{
    public String runRace() throws FileNotFoundException{
        Track myTrack = Track.createTrack();
        double max = 0.0;
        String first = "";
        Logger logger = new Logger();
        Pilot[] myPilots = myTrack.getPilots();
        for (Pilot pilot : myPilots) {
            basicScore(pilot);
            String str = randomEvents(pilot);
            if (str != null) {
                logger.Log("Ide jön a time stamp", str);
            }
            if (pilot.getPoint() > max){
                max = pilot.getPoint();
                first = pilot.getName();
            }
        }
        return first;
    }

    public void basicScore(Pilot pilot) {
        pilot.setPoint((pilot.getXp() * 2 + pilot.getCar().getTopSpeed()) / pilot.getCar().getAcceleration());
    }

    public String randomEvents(Pilot pilot) {
        Random random = new Random();
        int randomPercent = random.nextInt(pilot.getXp() / 5) + 1;
        if (randomPercent <= 4) {
            int randomEventPercent = random.nextInt(6);
            if (randomEventPercent == 1) {
                pilot.setPoint(0);
                return pilot.getName() + " distanced from the race.";
            } else if (randomEventPercent <= 3) {
                pilot.setPoint(pilot.getPoint() - 20);
                return pilot.getName() + " got a drive-through penalty.";
            } else {
                pilot.setPoint(pilot.getPoint() - 30);
                return pilot.getName() + " got a stop-and-go penalty.";
            }
        }
        return null;

    }
}