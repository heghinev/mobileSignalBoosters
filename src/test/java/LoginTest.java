import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

/**
 * Created by IntelliJ IDEA.
 * User: Heghine
 * Date: 12/11/17
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test
    public void login() {

        String email = TestUtils.randomEmail();

        registerUser(email);

        if (registerPage.isSuccessDisplayed()) {
            registerPage.logout();

            Assert.assertTrue(loginPage.isSigninDisplayed(), "Logout was not succeed!");

            loginPage.loginWith(email, TestUtils.DEFAULT_PASSWORD);
            Assert.assertTrue(loginPage.isSuccessDisplayed(), "Login was not succeed!");
        }
    }

    private void registerUser(String email) {
        registerPage.getRegistrationPage();
        TestUtils.fillUserData(registerPage, email);
    }
}



