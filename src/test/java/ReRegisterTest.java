import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

/**
 * Created by IntelliJ IDEA.
 * User: Heghine
 * Date: 12/11/17
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReRegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void reRegister() {

        String email = TestUtils.randomEmail();
        registerUser(email);

        if (registerPage.isSuccessDisplayed()) { // test for success registration is done in RegisterTest

            registerPage.logout();

            registerUser(email);

            Assert.assertTrue(registerPage.isErrorDisplayed(),
                    "Registration succeed!");
            Assert.assertEquals(registerPage.getErrorMessage(), "Error: An account is already " +
                    "registered with your email address. Please log in.");
        }
    }

    private void registerUser(String email) {
        registerPage.getRegistrationPage();
        TestUtils.fillUserData(registerPage, email);
    }

}