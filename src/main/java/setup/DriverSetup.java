package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER = System.getProperty("selenium.browser", "chrome");

    public static WebDriver getDriver(){
        if (driver == null){
            switch(BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver", "C:\\dev\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;

                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver", "C:\\dev\\geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            if (BROWSER.equals("firefox")){
                driver.close();
                driver = null;
            }else if(BROWSER.equals("chrome")){
                driver.close();
                driver.quit();
                driver = null;
            }
        }
    }
}


/*
mvn install -DskipTests
mvn test -Dselenium.browser=firefox
mvn test -piti ashxati chrome
mvn test -Dselenium.browser=chrome*/