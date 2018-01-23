public class Statictics {
    Pilot[] result;

    public Statictics(Pilot[] result){
        this.result = result;
    }

    public int sumOFPenalties(){
        int  penalties = 0;
        for (Pilot pilot :result){
            penalties +=pilot.getPenalties();
        }
        return penalties;
    }

    public double avarageOfPoints(){
        int  points = 0;
        for (Pilot pilot :result){
            points +=pilot.getPoint();
        }
        return points / 23;
    }
}