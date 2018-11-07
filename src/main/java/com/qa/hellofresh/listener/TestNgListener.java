package com.qa.hellofresh.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {

    private static String currentTest;
    private static ITestResult failedReult;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        failedReult = null;
        System.out.println("--- Starting : " + getMethodName(iTestResult));
        currentTest = getMethodName(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("--- Test Passed : " + getMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        failedReult = iTestResult;
        System.out.println("--- Test Failed : " + getMethodName(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("--- Test Skipped : " + getMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("--- All Test Execution Started ---");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("--- All Test Finished ---");
    }

    private static String getMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public static String getCurrentTest(){
        return currentTest;
    }

    public static ITestResult getFailedReult(){
        return failedReult;
    }
}
