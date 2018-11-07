package com.qa.hellofresh.base;

import com.qa.hellofresh.support.DriverConnection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public RemoteWebDriver driver;

    @BeforeMethod
    public void testStart(){
        driver = DriverConnection.getDriverInstance();
    }

    public RemoteWebDriver getDriver(){
        return driver;
    }


    @AfterMethod
    public void testFinished(){
        DriverConnection.closeDriver();
    }
}
