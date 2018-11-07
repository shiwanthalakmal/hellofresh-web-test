package com.qa.hellofresh.base;

import com.github.javafaker.Faker;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;

import java.util.Collection;
import java.util.Locale;

public class PageObject {

    public RemoteWebDriver driver;
    public Faker faker;

    public PageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.faker = new Faker(new Locale("en-IND"));;
    }

    public void verifyTrue(boolean condition, String message) {
            Assert.assertTrue(condition);
    }

    public void verifyFalse(boolean condition, String message) {
            Assert.assertFalse(condition);
    }

    public void verifyEquals(Object actual, Object expected, String message) {
            Assert.assertEquals(actual, expected);
    }

    public void verifyEquals(String actual, String expected, String message) {
            Assert.assertEquals(actual, expected);
    }

    public void verifyEquals(boolean actual, boolean expected, String message) {
            Assert.assertEquals(actual, expected);
    }

    public void verifyEquals(Collection<?> actual, Collection<?> expected, String message) {
            Assert.assertEquals(actual, expected);
    }

    public void verifyNotEquals(Object actual, Object expected, String message) {
            Assert.assertNotEquals(actual, expected);
    }

    public void verifyNotEquals(String actual, String expected, String message) {
            Assert.assertNotEquals(actual, expected, message);
    }

    public void verifyNotEquals(boolean actual, boolean expected, String message) {
            Assert.assertNotEquals(actual, expected);
    }
}
