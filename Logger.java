public class Logger {
    
    public void Log(String type, String message){
        System.out.println(type + " " + message);
    }
    
    public  void printMenu() {
        System.out.println("Welcome to Formula 1 betting simmulator\n");
        System.out.println("Menu\n");
        System.out.println(":winners");
        System.out.println(":funfacts");
        System.out.println(":stats");
        System.out.println(":exit");
        System.out.println("\nChoose :\n");
    }
    
    public  void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public  void basicPrinter(String str) {
        System.out.println(str);
    }
    public void StrArrPrinter(String messages, String[] str) {
        System.out.println(messages);
        for(String string : str) {
            System.out.println(string);
        }
    }
}