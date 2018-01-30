import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

/**
 * Created by IntelliJ IDEA.
 * User: Heghine
 * Date: 12/11/17
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
    }

    @Test
    public void login() {
        loginPage.loginWith("tomsmith", "SuperSecretPassword!");

        // if Enter is clicked on driver.findElement(By.id("password")).sendKeys(Keys.RETURN);

        AssertJUnit.assertTrue("Login was not succeed!", loginPage.isSuccessDisplayed());
    }


}