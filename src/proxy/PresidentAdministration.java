package proxy;
public class PresidentAdministration {
    private final President president;
    public PresidentAdministration(President president) {
        this.president = new AssistantPresident(president);
    }
    public President giveMeThePresident() {
        System.out.println("President Administration: President listen to you...");
        return this.president;
    }
}