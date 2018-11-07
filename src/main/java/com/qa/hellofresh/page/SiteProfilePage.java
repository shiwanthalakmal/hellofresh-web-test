package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteProfilePage extends PageObject {

    private By lbl_myAccount    = By.cssSelector("h1");
    private By lbl_welcomeMsg   = By.className("info-account");
    private By btn_profileName  = By.id("my-account");

    SiteHeaderPanel siteHeaderPanel;

    public SiteProfilePage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteProfilePage check_And_Validate_Current_URLContains(String contains){
        verifyTrue(driver.getCurrentUrl().contains(contains),"Error ! Url does not matching...");
        return this;
    }

    public SiteProfilePage check_And_Validate_MyAccount_Title(String title){
        verifyEquals(driver.findElement(lbl_myAccount).getText(),title,"Error ! Title does not matching...");
        return this;
    }

    public SiteProfilePage check_And_Validate_Welcome_Message(){
        verifyTrue(driver.findElement(lbl_welcomeMsg).getText().contains("Welcome to your account."),"Error ! Welcome mesage does not matching...");
        return this;
    }

    public SiteProfilePage check_Validate_UserProfile_Name(String profileName){
        siteHeaderPanel.action_Validate_UserProfile_Name(profileName);
        return this;
    }

    public SiteLoginPage step_Perform_SignOut_Button_If_Available(){
        siteHeaderPanel.action_Perform_SignOut_Button();
        return new SiteLoginPage(driver);
    }

    public SiteBrowsPage step_Navigate_Woman_Collection_Using_MainMenu(){
        siteHeaderPanel.action_Navigate_Woman_Collection_Using_MainMenu();
         return new SiteBrowsPage(driver);
    }

    public SiteProfilePage check_And_Validate_ProfileName(){

        return this;
    }
}
