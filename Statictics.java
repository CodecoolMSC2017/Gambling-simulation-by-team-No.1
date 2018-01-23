public class Statictics {
    Pilot[] result;
    int sumOfPenalties;
    double averageOfPoints;
    double averageSpeed;

    public Statictics(Pilot[] result){
        this.result = result;
        this.sumOfPenalties = sumOFPenalties();
        this.averageOfPoints = averageOfPoints();
        this.averageSpeed = averageSpeed();
    }
    public int sumOFPenalties(){
        int  penalties = 0;
        for (Pilot pilot :result){
            penalties +=pilot.getPenalties();
        }
        return penalties;
    }

    public double averageOfPoints(){
        int  points = 0;
        for (Pilot pilot :result){
            points +=pilot.getPoint();
        }
        return points / 23;
    }
    
    public double averageSpeed(){
        int speed = 0;
        for (Pilot pilot :result){
            speed += pilot.getCar().getTopSpeed();
        }
        return speed / 23;
    }
    public Pilot[] getResult() {
        return result;
    }

}