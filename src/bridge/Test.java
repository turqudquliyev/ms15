package bridge;
public class Test {
    public static void main(String[] args) {
        OperatingSystem linux = new LinuxOS();
        OperatingSystem windows = new WindowsOS();
        JavaRuntimeEnvironment jvmOnLinux = new JavaVirtualMachine(linux);
        JavaRuntimeEnvironment jvmOnWindows = new JavaVirtualMachine(windows);
        jvmOnLinux.run("Main.class");
        jvmOnWindows.run("Main.class");
    }
}