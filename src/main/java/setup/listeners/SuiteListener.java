package setup.listeners;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static setup.DriverSetup.getDriver;

public class SuiteListener extends TestListenerAdapter {
    private static Logger Log = Logger.getLogger(SuiteListener.class.getName());

    @Override
    public void onTestFailure(ITestResult currentTest){
        Log.info("Taking a screenshot");
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File screenShotName = new File(".\\target\\screenshots\\" + currentTest.getName() + timeStamp + ".png");
        try{
            FileUtils.copyFile(scrFile, screenShotName);
        } catch(IOException e){
            e.printStackTrace();
        }
        Log.info("***************************************************************************************************");
        Log.info("Failed ----> " + currentTest.getName());
        Log.info("***************************************************************************************************");
    }

    @Override
    public void onTestStart(ITestResult currentTest){
        Log.info("***************************************************************************************************");
        Log.info("Started to run ---> " + currentTest.getName());
        Log.info("***************************************************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult currentTest){
        Log.info("************************************************* **************************************************");
        Log.info("Finished ---> " + currentTest.getName());
        Log.info("***************************************************************************************************");
    }
}
