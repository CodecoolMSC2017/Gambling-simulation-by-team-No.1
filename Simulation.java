public class Simulation {

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

    public Pilot[] load() {
        return PilotReading("firsts.csv");
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