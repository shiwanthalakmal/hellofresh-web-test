package com.qa.hellofresh.panel;

import com.qa.hellofresh.base.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteHeaderPanel extends PageObject{

    private By btn_signIn       = By.linkText("Sign in");
    private By btn_signOut      = By.linkText("Sign out");
    private By btn_profile      = By.className("account");
    private By btn_contactUs    = By.linkText("Contact us");

    private By btn_menu_women   = By.linkText("Women");

    public SiteHeaderPanel(RemoteWebDriver driver) {
        super(driver);
    }

    public void action_Perform_SingIn_Button(){
        driver.findElement(btn_signIn).click();
    }

    public void action_Perform_SingOut_Button(){
        driver.findElement(btn_signOut).click();
    }

    public void action_Perform_ContactUs_Button(){
        driver.findElement(btn_contactUs).click();
    }

    public void action_Validate_UserProfile_Name(String profileName){
        verifyEquals(driver.findElement(btn_profile).getText(),profileName,"Error ! Profile does not matching ..");
    }

    public void action_Perform_SignOut_Button(){
        if(driver.findElement(btn_signOut).isDisplayed()){
            driver.findElement(btn_signOut).click();
        }
    }

    public void action_Navigate_Woman_Collection_Using_MainMenu(){
        driver.findElement(btn_menu_women).click();
    }
}
