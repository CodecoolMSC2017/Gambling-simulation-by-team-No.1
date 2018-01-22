public class Pilot{

    String name;
    int xp;
    Car car;

    public Pilot(String name, int xp, Car car){
        this.name = name;
        this.xp = xp;
        this car = car;
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