import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Track{
    String trackName;
    Pilot[] pilots;

    public Track(String trackName, String CSVPath) throws FileNotFoundException {
        this.trackName = trackName;
        this.pilots = PilotReading(CSVPath);

    }

    static Track createTrack() throws FileNotFoundException{
        return new Track("Hungaroring", "data.csv");
    }

    public int lineCounter(String CSVPath) {
        int cnt = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSVPath))) {
            while ((reader.readLine()) != null) {
                cnt++;
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cnt;
    }

    public Pilot[] PilotReading(String CSVPath) throws FileNotFoundException {
        int numOFLines = lineCounter(CSVPath);
        int lineNumber = 0;
        String line = "";
        Pilot[] pilots = new Pilot[numOFLines];
        try (BufferedReader pilotReader = new BufferedReader(new FileReader(CSVPath))) {
            while ((line = pilotReader.readLine()) != null) {
                String[] attributes = line.split(";");
                pilots[lineNumber] = createPilot(attributes);
                lineNumber++;
            }
            pilotReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return pilots;
    }

    public Pilot createPilot(String[] attrib) {
        return new Pilot(attrib[0], attrib[1], Integer.parseInt(attrib[2]),
                new Car(attrib[3], Integer.parseInt(attrib[4]), Double.parseDouble(attrib[5])),
                Double.parseDouble(attrib[6]), Integer.parseInt(attrib[7]));
    }

    public Pilot[] getPilots() {
        return pilots;
    }

    public void removePilot(String name){
        for (int i = 0; i < pilots.length; i++) {
            if (pilots[i].getName().equals(name)) {
                Pilot[] copy = new Pilot[pilots.length - 1];
                System.arraycopy(pilots, 0, copy, 0, i);
                System.arraycopy(pilots, i + 1, copy, i, pilots.length - i - 1);
                pilots = copy;
            }
        }
    }
}