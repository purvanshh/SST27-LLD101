interface Logger {
    void log(String msg);
}

public class ConsoleLogger implements Logger {
    public void log(String msg){ 
        System.out.println("[LOG] " + msg); 
    }
}