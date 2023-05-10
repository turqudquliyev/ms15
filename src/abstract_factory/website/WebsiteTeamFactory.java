package abstract_factory.website;
import abstract_factory.Developer;
import abstract_factory.ProductOwner;
import abstract_factory.ProjectTeamFactory;
import abstract_factory.Tester;
public class WebsiteTeamFactory implements ProjectTeamFactory {
    public Developer getDeveloper() {
        return new PythonDeveloper();
    }
    public Tester getTester() {
        return new ManualTester();
    }
    public ProductOwner getProductOwner() {
        return new WebsitePO();
    }
}