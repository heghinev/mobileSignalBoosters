import org.testng.Assert;
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
        wrongLoginPage.loginWith(TestUtils.randomEmail(), "1");
        Assert.assertTrue(wrongLoginPage.isErrorDisplayed(),
                "Login succeed!");
        Assert.assertEquals(wrongLoginPage.getErrorMessage(), "Error: A user could not be found with this email address.");
    }
}
