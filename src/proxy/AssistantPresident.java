package proxy;
public class AssistantPresident implements President {
    private final President realPresident;
    private static int count = 0;
    public AssistantPresident(President realPresident) {
        this.realPresident = realPresident;
    }
    public void listenRequests(String request) {
        System.out.println("Assistant President: I'm listening!");
        this.forwardRequests(request);
    }
    public void listenProblems(String problem) {
        System.out.println("Assistant President: I'm listening!");
        this.solveProblems(problem);
    }
    private void forwardRequests(String request) {
        this.realPresident.listenRequests(request);
    }
    private void forwardProblems(String problem) {
        this.realPresident.listenProblems(problem);
    }
    private void solveProblems(String problem) {
        ++count;
        if (count % 2 != 0) {
            this.forwardProblems(problem);
        } else {
            System.out.println("Assistant President: We will contact you!");
        }
    }
}