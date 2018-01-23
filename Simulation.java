import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Simulation {

    public void generateData(Pilot[] pilots)throws FileNotFoundException {
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

    public Pilot[] load()throws FileNotFoundException {
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

    public Pilot[] makeStatics(Pilot[] old, Pilot[] res){
        for(int i = 0;i<old.length;i++){
            old[i].setPoint(res[i].getPoint());
            old[i].setPenalties(res[i].getPenalties());
        }
        return old;
    }

}