package proxy;
public class RealPresident implements President {
    public void listenRequests(String request) {
        System.out.println("Real President: I'm listening!");
    }
    public void listenProblems(String problem) {
        System.out.println("Real President: I'm listening!");
    }
}