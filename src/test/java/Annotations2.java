import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Annotations2 {


    @BeforeSuite
    public void InstallSoftware() {

        System.out.println("I'm the first!!");

    }

    @AfterSuite
    public void UninstallSoftware() {

        System.out.println("I'm the last!!");

    }
}
