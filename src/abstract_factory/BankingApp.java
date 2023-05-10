package abstract_factory;
import abstract_factory.banking.BankingTeamFactory;
public class BankingApp {
    public static void main(String[] args) {
        BankingTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProductOwner po = projectTeamFactory.getProductOwner();
        System.out.println("Building banking app");
        developer.writeCode();
        tester.testCode();
        po.manageProduct();
    }
}