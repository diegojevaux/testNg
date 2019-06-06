package pack2;

import org.testng.annotations.*;

public class Annotations {

    @BeforeMethod //Executes on every method
    public void UserIdGenerator() {
        System.out.println("Executes on every method");
    }

    @BeforeTest //Executes once before all tests
    public void Cookies() {
        System.out.println("Executes once before all tests");

    }

    @AfterTest//Executes once after all tests
    public void CookiesErase() {
        System.out.println("Executes once after all tests");
    }

    @AfterMethod
    public void ReportAdding() {
        System.out.println("Executes after every method");
    }


    @Test
    public void OpeningBrowser() {
        System.out.println("open browser");

    }

    @Test
    public void FlightBooking() {
        System.out.println("flight");
    }

}
