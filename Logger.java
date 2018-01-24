public class Logger {
    
    public void Log(String type, String message){
        System.out.println(type + " " + message);
    }
    
    public static void printMenu() {
        System.out.println("Welcome to Formula 1 betting simmulator\n");
        System.out.println("Menu\n");
        System.out.println(":winners");
        System.out.println(":funfacts");
        System.out.println(":stats");
        System.out.println("\nChoose :\n");
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public static void basicPrinter(String str) {
        clearScreen();
        System.out.println(str);
        Main.menus();
    }
}