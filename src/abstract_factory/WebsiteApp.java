package abstract_factory;
import abstract_factory.website.WebsiteTeamFactory;
public class WebsiteApp {
    public static void main(String[] args) {
        WebsiteTeamFactory projectTeamFactory = new WebsiteTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProductOwner po = projectTeamFactory.getProductOwner();
        System.out.println("Build website");
        developer.writeCode();
        tester.testCode();
        po.manageProduct();
    }
}