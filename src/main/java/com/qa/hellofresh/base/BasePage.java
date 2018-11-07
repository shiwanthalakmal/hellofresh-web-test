package com.qa.hellofresh.base;

import com.github.javafaker.Faker;
import com.qa.hellofresh.element.*;
import com.qa.hellofresh.element.Button;
import com.qa.hellofresh.element.Label;
import com.qa.hellofresh.element.TextField;
import com.qa.hellofresh.exception.FrameworkException;
import com.qa.hellofresh.support.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;

import java.awt.*;
import java.util.Collection;
import java.util.Locale;

public class BasePage {

    public RemoteWebDriver driver;
    public Faker faker;

    public BasePage(RemoteWebDriver driver)
    {
        this.driver = driver;
        this.faker = new Faker(new Locale("en-IND"));;
    }

    /**
     * Locate button element.
     *
     * @param findBy mechanism to locate the button.
     * @return Located button
     */
    public Button button(By findBy)
    {
        return new Button(driver,findBy);
    }

    public TextField textfield(By findBy) throws FrameworkException{
        return new TextField(driver,findBy);
    }

    public Link link(By findBy)
    {
        return new Link(driver,findBy);
    }

    public CheckBox checkBox(By findBy)
    {
        return new CheckBox(driver,findBy);
    }

    public Label label(By findBy)
    {
        return new Label(driver,findBy);
    }

    public DropdownList dropdownList(By findBy)
    {
        return new DropdownList(driver,findBy);
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
