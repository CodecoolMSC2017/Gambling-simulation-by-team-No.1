public class Pilot{

    String name;
    int xp;

    public Pilot(String name, int xp){
        this.name = name;
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