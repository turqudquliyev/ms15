package abstract_factory.banking;
import abstract_factory.Developer;
import abstract_factory.ProductOwner;
import abstract_factory.ProjectTeamFactory;
import abstract_factory.Tester;
public class BankingTeamFactory implements ProjectTeamFactory {
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }
    public Tester getTester() {
        return new QATester();
    }
    public ProductOwner getProductOwner() {
        return new BankingPO();
    }
}