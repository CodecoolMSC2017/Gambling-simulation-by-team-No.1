import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

public class Simulation {

    String trackName;
    Pilot[] pilots;

    public Simulation(String trackName, String CSVpath) {
        this.trackName = trackName;
        this.pilots = PilotReading(CSVPath);

    }

    public void generateData(Pilot[] pilots) {
        String[] attributes = null;
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("firsts.csv"));
            StringBuilder sb = new StringBuilder();
            for (Pilot pilot : pilots) {
                int collCnt = 0;
                attributes = decompressPilot(pilot);
                for (String att : attributes) {
                    sb.append(att);
                    collCnt++;
                    if (collCnt != 6) {
                        sb.append(",");
                    }

                }
                sb.append("\n");
            }
            String mystr = sb.toString();
            mystr = mystr.substring(0, mystr.length() - 1);
            bw.write(mystr);
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    static Simulation createSimulation() {
        return new Simulation("Hungaroring", "data.csv");
    }

    public Pilot[] load() {
        return PilotReading("firsts.csv");
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
        return new Pilot(attrib[0], attrib[1], Integer.parseInt(attrib[2]),
                new Car(attrib[4], Integer.parseInt(attrib[5]), Integer.parseInt(attrib[6])),
                Double.parseDouble(attrib[7]));
    }

    public Pilot[] getPilots() {
        return pilots;
    }

    public String[] decompressPilot(Pilot pilot) {
        String[] attributes = new String[6];
        attributes[0] = pilot.getName();
        attributes[1] = pilot.getNationality();
        attributes[2] = Integer.toString(pilot.getXp());
        attributes[3] = pilot.getCar().getTeamName();
        attributes[4] = Integer.toString(pilot.getCar().getTopSpeed());
        attributes[5] = Double.toString(pilot.getCar().getAcceleration());
        attributes[6] = Double.toString(pilot.getPoint());
        return attributes;

    }

}