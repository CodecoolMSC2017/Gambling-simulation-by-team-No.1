import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;

public class Simulation {
    Pilot[] result;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public Simulation(Pilot[] result) {
        this.result = result;
    }

    public void generateData(Pilot[] pilots) throws FileNotFoundException {
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
                    if (collCnt != 8) {
                        sb.append(";");
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

    public Pilot[] FirstSix(Pilot[] pilots) {
        Pilot place = pilots[0];
        Pilot[] firstSix = new Pilot[6];
        double max = 0.0;
        for (int i = 0; i < 6; i++) {
            for (Pilot pilot : pilots) {
                if (pilot.getPoint() > max) {
                    max = pilot.getPoint();
                    place = pilot;
                }
            }
            max = 0;
            firstSix[i] = place;
            pilots = removePilot(pilots, place.getName());
        }
        return firstSix;

    }

    public String[] FirstSixNames(Pilot[] pilot) {
        Pilot[] firstSix = FirstSix(pilot);
        String[] winnersName = new String[6];
        for (int i = 0; i < firstSix.length; i++) {
            winnersName[i] = firstSix[i].getName();

        }
        return winnersName;
    }

    public Pilot[] removePilot(Pilot[] pilots, String name) {
        Pilot[] ret = pilots;
        for (int i = 0; i < pilots.length; i++) {
            if (pilots[i].getName().equals(name)) {
                Pilot[] copy = new Pilot[pilots.length - 1];
                System.arraycopy(pilots, 0, copy, 0, i);
                System.arraycopy(pilots, i + 1, copy, i, pilots.length - i - 1);
                ret = copy;
            }
        }
        return ret;
    }

    public void generateData(String[] firstSix) throws FileNotFoundException {

        BufferedWriter bw = null;
        FileWriter fw = null;
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(new Timestamp(date.getTime()));
        sb.append(";");
        for (int i = 0; i < firstSix.length; i++) {
            sb.append(firstSix[i]);
            if (i == firstSix.length-1) {
                sb.append(";");
                sb.append(cntDatas(firstSix));
                sb.append("\n");
            } else {
                sb.append(";");
            }

        }
        try {

            File file = new File("final.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(sb.toString());
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }

    public Pilot[] load() throws FileNotFoundException {
        Track track = Track.createTrack();
        return track.PilotReading("firsts.csv");
    }

    public int cntDatas(String[] best) throws FileNotFoundException {
        Track track = Track.createTrack();
        int numOFLines = track.lineCounter("final.csv");
        int good = 1;
        String line = "";
            try (BufferedReader pilotReader = new BufferedReader(new FileReader("final.csv"))) {
                while ((line = pilotReader.readLine()) != null) {
                    int cnt = 0;
                    String[] attributes = line.split(";");
                    String[] x = createNameArr(attributes);
                    for (int i = 0;i<x.length;i++){
                        if (best[i].equals(x[i])){
                            cnt++;
                        }
                    }
                    if (cnt == 6){
                        good++;
                    }

                    
                }
                pilotReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return good;

        }


    public String[] decompressPilot(Pilot pilot) {
        String[] attributes = new String[8];
        attributes[0] = pilot.getName();
        attributes[1] = pilot.getNationality();
        attributes[2] = Integer.toString(pilot.getXp());
        attributes[3] = pilot.getCar().getTeamName();
        attributes[4] = Integer.toString(pilot.getCar().getTopSpeed());
        attributes[5] = Double.toString(pilot.getCar().getAcceleration());
        attributes[6] = Double.toString(pilot.getPoint());
        attributes[7] = Integer.toString(pilot.getPenalties());
        return attributes;

    }

    public void makeStatics(Pilot[] old, Pilot[] res) {
        for (int i = 0; i < old.length; i++) {
            old[i].setPoint(old[i].getPoint() + res[i].getPoint());
            old[i].setPenalties(res[i].getPenalties());
        }
        result = old;
    }

    public Pilot[] getPilotArr() {
        return result;
    }

    public String[] createNameArr(String[] splitted) {
        String[] attributes = new String[6];
        attributes[0] = splitted[1];
        attributes[1] = splitted[2];
        attributes[2] = splitted[3];
        attributes[3] = splitted[4];
        attributes[4] = splitted[5];
        attributes[5] = splitted[6];
        return attributes;
    }

    public String[] loadDatas(int colNum) throws FileNotFoundException {
        Track track = Track.createTrack();
        int numOFLines = track.lineCounter("final.csv");
        String line = "";
        System.out.println(numOFLines);
        String[] col = new String[numOFLines];
            try (BufferedReader pilotReader = new BufferedReader(new FileReader("final.csv"))) {
                for(int i = 0;i<numOFLines;i++) {
                    line = pilotReader.readLine();
                    String[] row = line.split(";");
                    col[i] = row[colNum];
                }

                    
                pilotReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return col;

        }
}