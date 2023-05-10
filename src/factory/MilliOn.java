package factory;
public class MilliOn implements Terminal {
    public void pay(String amount) {
        System.out.println("Thanks for used to MilliOn");
        System.out.println("The payment successfully completed.\nAmount: " + amount);
    }
}