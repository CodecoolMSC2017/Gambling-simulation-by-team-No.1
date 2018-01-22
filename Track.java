public class Track{

    String name;
    Pilot[] pilots;

    public Track(String name, String CSVpath){
        this.name=name;
        this.pilots = PilotReading(CSVPath);

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
                String[] attributes = line.split(",");
                pilots[lineNumber] = createPilot(attributes);
                lineNumber++;
            }
            survivorReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return survivors;
    }
    public Pilot createPilot(String[] attrib) {
        return new Pilot(attrib[0], attrib[1], Integer.parseInt(attrib[2]),new Car(attrib[4], Integer.parseInt(attrib[5]), Integer.parseInt(attrib[6])));
    }
    public static Track createTrack(){
        return new Track("Hungaroring", "data.csv");
    }
}