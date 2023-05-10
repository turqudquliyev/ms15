package factory;
public class MilliOnTerminalFactory implements TerminalFactory {
    public Terminal payWithTerminal() {
        return new MilliOn();
    }
}