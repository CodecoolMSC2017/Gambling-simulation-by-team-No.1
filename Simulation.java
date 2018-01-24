import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            if (i == firstSix.length - 1) {
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
}