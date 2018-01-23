public class Statictics {
    Pilot[] result;
    int sumOfPenalties;

    public Statictics(Pilot[] result){
        this.result = result;
        this.sumOfPenalties = sumOFPenalties();
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
    
    
    public double avarageSpeed(){
        int speed = 0;
        for (Pilot pilot :result){
            speed += pilot.getCar().getTopSpeed();
        }
        return speed / 23;
    }
}