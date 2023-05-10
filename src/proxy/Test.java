package proxy;
public class Test {
    public static void main(String[] args) {
        President president = new RealPresident();
        PresidentAdministration presidentAdministration = new PresidentAdministration(president);
        Citizen turgud = new Citizen(presidentAdministration);
        turgud.sayProblems("I have a problem ... ");
        turgud.sayRequests("I want to ... ");
        turgud.sayProblems("I have a problem ... ");
    }
}