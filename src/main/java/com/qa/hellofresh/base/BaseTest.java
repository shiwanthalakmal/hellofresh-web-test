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
        String exePath = "D:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");
    }

    public RemoteWebDriver getDriver(){
        return driver;
    }


    @AfterMethod
    public void testFinished(){
        driver.close();
        driver.quit();
    }

}
