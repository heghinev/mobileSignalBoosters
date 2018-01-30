package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameLocator;
    @FindBy(id = "password")
    private WebElement passwordLocator;
    @FindBy(css = "#login button")
    private WebElement submitLocator;
    @FindBy(css = ".flash.success")
    private WebElement successLocator;
    @FindBy(css = ".flash.error")
    private WebElement errorLocator;


    public LoginPage() {
        super(getDriver());
        visit(getUrl());
    }

    public String getUrl(){
        return BASE_URL + "/login";
    }


    public String getURL() {
        return driver.getCurrentUrl();
    }

    public void loginWith(String username, String password) {

        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
        submitLocator.click();
    }

    public boolean isSuccessDisplayed() {
        try {
            return successLocator.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isErrorDisplayed() {
        return errorLocator.isDisplayed();
    }

    public String getErrormessage() {
        return errorLocator.getText();
    }
}
