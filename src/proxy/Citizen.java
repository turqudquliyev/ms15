package proxy;
public class Citizen {
    private final President president;
    public Citizen(PresidentAdministration presidentAdministration) {
        this.president = presidentAdministration.giveMeThePresident();
    }
    public void sayProblems(String problem) {
        System.out.println("Citizen: " + problem);
        this.president.listenProblems(problem);
    }
    public void sayRequests(String request) {
        System.out.println("Citizen: " + request);
        this.president.listenRequests(request);
    }
}