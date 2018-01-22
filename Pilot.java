public class Pilot{

    String name;
    String nationality;
    int xp;
    Car car;
    

    public Pilot(String name, String nationality, int xp, Car car){
        this.name = name;
        this.nationality = nationality;
        this.xp = xp;
        this.car = car;
        
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