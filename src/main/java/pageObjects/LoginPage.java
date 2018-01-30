package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    @FindBy(xpath = "/html/body/div[2]/nav/div/div/div[3]/div[2]/div/a")
    private WebElement signinLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/div[2]/div[1]/input")
    private WebElement usernameLocator;
    @FindBy(id = "password")
    private WebElement passwordLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/div[2]/div[3]/input[3]")
    private WebElement loginLocator;
    @FindBy(xpath = "//div[@class='profile-name']")
    private WebElement myAccountLocator;
    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    private WebElement errorLocator;

    public LoginPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void loginWith(String username, String password) {
        click(signinLocator);
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginLocator);
    }

    public boolean isSuccessDisplayed() {
        return isDisplayed(myAccountLocator);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorLocator);
    }

    public boolean isSigninDisplayed() {
        return isDisplayed(signinLocator);
    }

    public String getErrorMessage() {
        return errorLocator.getText();
    }
}
