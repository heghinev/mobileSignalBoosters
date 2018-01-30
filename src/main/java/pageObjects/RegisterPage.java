package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.WaitHelper;

import static setup.DriverSetup.getDriver;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "/html/body/div[2]/nav/div/div/div[3]/div[2]/div/a")
    private WebElement signinLocator;
    @FindBy(id = "register_block")
    private WebElement registerLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[1]/div[2]/div[1]/div[1]/input")
    private WebElement emailLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[1]/div[2]/div[1]/div[2]/input")
    private WebElement passwordLocator;
    @FindBy(id = "email_password_submit")
    private WebElement continue1Locator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[2]/div[2]/div[1]/div[1]/input")
    private WebElement firstNameLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[2]/div[2]/div[1]/div[2]/input")
    private WebElement lastNameLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[2]/div[2]/div[1]/div[4]/input")
    private WebElement phoneLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[2]/div[2]/div[1]/div[5]/input")
    private WebElement zipCodeLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[2]/div[2]/div[1]/div[6]/input")
    private WebElement countryLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[2]/div[2]/div[1]/div[7]/input")
    private WebElement address1Locator;
    @FindBy(id = "second_submit")
    private WebElement continue2Locator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[3]/div[2]/div[1]/div[1]/input")
    private WebElement shippingZipCodeLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[3]/div[2]/div[1]/div[2]/input")
    private WebElement shippingCityLocator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[3]/div[2]/div[1]/div[3]/input")
    private WebElement address2Locator;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/div[3]/div[2]/div[2]/input")
    private WebElement submitLocator;
    // success page contains user name inside div
    @FindBy(xpath = "//div[@class='profile-name']")
    private WebElement myAccountLocator;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    private WebElement errorLocator;

    @FindBy(xpath = "/html/body/div[2]/nav/div/div/div[3]/div[2]/div[3]/ul/li[7]/a")
    private WebElement logoutLocator;

    public RegisterPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL;
    }

    public void getRegistrationPage() {
        click(signinLocator);
        click(registerLocator);
    }

    public void registerWith(String email, String password) {
        WaitHelper.getWait()
                .waitForElementToBeVisible(emailLocator)
                .waitForElementToBeVisible(passwordLocator)
                .waitForElementToBeClickable(continue1Locator);
        type(emailLocator, email);
        type(passwordLocator, password);
        click(continue1Locator);
    }

    public void regWithAddressData(String fName, String lName, String phone, String zip, String country, String address1) {
        type(firstNameLocator, fName);
        type(lastNameLocator, lName);
        type(phoneLocator, phone);
        type(zipCodeLocator, zip);
        type(countryLocator, country);
        type(address1Locator, address1);
        click(continue2Locator);
    }

    public void regWithShippingData(String shippingZip, String city, String address2) {
        type(shippingZipCodeLocator, shippingZip);
        type(shippingCityLocator, city);
        type(address2Locator, address2);
        click(submitLocator);
    }

    public boolean isSuccessDisplayed() {
        return isDisplayed(myAccountLocator);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorLocator);
    }

    public String getErrorMessage() {
        return errorLocator.getText();
    }

    public void logout() {
        click(myAccountLocator);
        click(logoutLocator);
    }
}
