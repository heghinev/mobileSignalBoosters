import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class WrongLoginTest {
    private LoginPage wrongLoginPage;


    @BeforeMethod
    public void setUp() {
        wrongLoginPage = new LoginPage();
    }

    @Test
    public void loginFail() {
        wrongLoginPage.loginWith("bla", "blabla!");
        assertTrue("Login was not succeed!",
                wrongLoginPage.isErrorDisplayed());
        assertTrue("Error message is not correct!",
                wrongLoginPage.getErrormessage().contains("Your username is invalid!"));


    }

    private void assertTrue(String s, boolean displayed) {
        //To change body of created methods use File | Settings | File Templates.
    }


}