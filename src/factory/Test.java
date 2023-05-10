package factory;
public class Test {
    public static void main(String[] args) {
        TerminalFactory terminalFactory = createTerminalFactory(TerminalName.EManat);
        Terminal terminal = terminalFactory.payWithTerminal();
        terminal.pay("500");
    }
    private static TerminalFactory createTerminalFactory(TerminalName name) {
        return switch (name) {
            case EManat -> new EManatTerminalFactory();
            case MilliOn -> new MilliOnTerminalFactory();
        };
    }
}