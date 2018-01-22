public class Car {
    private String teamName;
    private int topSpeed;
    private double acceleration; 

    public Car(String teamName, int topSpeed, double acceleration){
        this.teamName = teamName;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
    }

    public String getTeamName(){
        return teamName;
    }
    public int getTopSpeed(){
        return topSpeed;
    }
    public double getAcceleration(){
        return acceleration;
    }
}