package bridge;
public class JavaVirtualMachine implements JavaRuntimeEnvironment {
    private final OperatingSystem operatingSystem;
    public JavaVirtualMachine(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public void run(String filename) {
        String command = "java " + filename;
        this.operatingSystem.execute(command);
    }
}