package bridge;
public class WindowsOS implements OperatingSystem {
    public void execute(String command) {
        System.out.println("Executing " + command + " command on Windows");
    }
}