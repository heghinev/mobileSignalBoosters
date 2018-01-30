package setup.listeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static Logger Log = Logger.getLogger(RetryAnalyzer.class.getName());

    private int retryCount = 0;
    private int maxRetryCount = 3;

    public boolean retry(ITestResult result){
        if(retryCount < maxRetryCount){

            Log.info("Retry test " + result.getName() + " with status" + getResultStatusName(result.getStatus())
                    + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status){
        String resultName = null;
        if(status == 1)
            resultName = "SUCCESS";
        if(status == 2)
            resultName = "FAILURE";
        if(status == 3)
            resultName = "SKIP";
        return resultName;
    }

}
