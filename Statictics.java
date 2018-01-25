public class Statictics {
    Pilot[] result;
    int sumOfPenalties;
    double averageOfPoints;
    double averageSpeed;
    int round;

    public Statictics(Pilot[] result, int round){
        this.result = result;
        this.round = round;
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
        return points / 23 / round;
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

    public double avgPenaltiesPerPilot(){
        int divident = sumOfPenalties;
        return ((double)divident) / 23.0;
    }

}