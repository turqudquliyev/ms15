package factory;
public class EManatTerminalFactory implements TerminalFactory {
    public Terminal payWithTerminal() {
        return new EManat();
    }
}