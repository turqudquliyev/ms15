package bridge;
public class LinuxOS implements OperatingSystem {
    public void execute(String command) {
        System.out.println("Executing " + command + " command on Linux");
    }
}