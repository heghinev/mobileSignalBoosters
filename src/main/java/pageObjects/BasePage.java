package pageObjects;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;



public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private static Logger log = Logger.getLogger(Log.class.getName());
    protected WebDriver driver;
    public static final String BASE_URL = System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage(WebDriver webdriver) {
        this.driver = webdriver;
    }

    public void visit(String url) {
        log.info("Visiting " + url);
        driver.get(url);
        PageFactory.initElements(driver, this);
        this.get();
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public WebElement find(String cssSelector) {
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        click(find(locator));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(String cssSelector) {
        click(find(cssSelector));
    }

    public void type(By locator, String text) {
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text) {
        type(find(cssSelector), text);
    }

    public boolean isDisplayed(WebElement element) {
        log.info("Checking element visibility " + element.toString());
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(find(locator));
    }
    public boolean isDisplayed(String cssSelector) {
        return isDisplayed(find(cssSelector));
    }

    public abstract  String getUrl();

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(getUrl());
    }

}
