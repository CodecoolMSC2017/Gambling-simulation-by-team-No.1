public class Pilot {

    String name;
    String nationality;
    int xp;
    Car car;
    double points;
    int penalties;

    public Pilot(String name, String nationality, int xp, Car car, double points, int penalties) {
        this.name = name;
        this.nationality = nationality;
        this.xp = xp;
        this.car = car;
        this.points = points;
        this.penalties = penalties;

    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public Car getCar(){
        return car;
    }

    public int getXp() {
        return xp;
    }

    public double getPoint() {
        return points;
    }

    public void setPoint(double value) {
        points = value;
    }
    public int getPenalties(){
        return penalties;
    }
    public void setPenalties(int value){
        penalties += value;
    }
}