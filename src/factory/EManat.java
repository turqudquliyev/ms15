package factory;
public class EManat implements Terminal {
    public void pay(String amount) {
        System.out.println("Thanks for used to EManat");
        System.out.println("The payment successfully completed.\nAmount: " + amount);
    }
}