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
public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        registerPage = new RegisterPage();
    }

    @Test
    public void register() {
        registerPage.getRegistrationPage();

        TestUtils.fillUserData(registerPage, TestUtils.randomEmail());

        Assert.assertTrue(registerPage.isSuccessDisplayed(), "Registration was not succeed!");
    }

}