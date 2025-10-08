package testCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3;

 /*   @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + ", attempt " + retryCount);
            return true;
        }
        return false;
    }*/
    
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;

            // Yeh line ensure karegi ki intermediate retries report me na aaye
            result.setStatus(ITestResult.FAILURE);

            System.out.println("Retrying test: " + result.getName() + ", attempt " + retryCount);
            return true;
        }
        return false;
    }
}