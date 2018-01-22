public class Pilot{

    String name;
    String nationality;
    Car car;
    int xp;

    public Pilot(String name, String nationality, Car car, int xp){
        this.name = name;
        this.nationality = nationality;
        this.car = car;
        this.xp = xp;
    }
    public String getName(){
        return name;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int value) {
        xp += value;
    }

}