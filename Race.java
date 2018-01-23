import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Race {
    public Pilot[] runRace() throws FileNotFoundException {
        Track myTrack = Track.createTrack();
        double max = 0.0;
        Pilot[] myPilots = myTrack.getPilots();
        Pilot place =myPilots[0];
        Pilot[] firstSix = new Pilot[6];
        for (int i = 0; i < 6; i++) {
            myPilots = myTrack.getPilots();
            for (Pilot pilot : myPilots) {
                basicScore(pilot);
                randomEvents(pilot);
                if (pilot.getPoint() > max) {
                    max = pilot.getPoint();
                    place = pilot;
                }
            }
            max = 0;
            firstSix[i] = place;
            myTrack.removePilot(place.getName());
            }
        return firstSix;
    }

    public void basicScore(Pilot pilot) {
        pilot.setPoint((pilot.getXp() * 2 + pilot.getCar().getTopSpeed()) / pilot.getCar().getAcceleration());
    }

    public void randomEvents(Pilot pilot) {
        Random random = new Random();
        int randomPercent = random.nextInt(pilot.getXp() / 5) + 1;
        if (randomPercent <= 4) {
            int randomEventPercent = random.nextInt(6);
            if (randomEventPercent == 1) {
                pilot.setPoint(0);
                pilot.setPenalties();
            } else if (randomEventPercent <= 3) {
                pilot.setPoint(pilot.getPoint() - 20);
                pilot.setPenalties();
            } else {
                pilot.setPoint(pilot.getPoint() - 30);
                pilot.setPenalties();
            }
        }

    }
}