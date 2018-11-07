package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteProfilePage extends BasePage {

    private By lbl_myAccount    = By.cssSelector("h1");
    private By lbl_welcomeMsg   = By.className("info-account");
    private By btn_profileName  = By.id("my-account");

    SiteHeaderPanel siteHeaderPanel;

    public SiteProfilePage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Verify current page url
     * @param contains
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_Current_URLContains(String contains){
        verifyTrue(driver.getCurrentUrl().contains(contains),"Error ! Url does not matching...");
        return this;
    }

    /**
     * Step: Verify my-account page title
     * @param title
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_MyAccount_Title(String title) throws ScriptException, ApplicationException {
        verifyEquals(label(lbl_myAccount).getText(),title,"Error ! Title does not matching...");
        return this;
    }

    /**
     * Step: Verify profile create success welcome message
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_Welcome_Message() throws ScriptException, ApplicationException {
        verifyTrue(label(lbl_welcomeMsg).getText().contains("Welcome to your account."),"Error ! Welcome mesage does not matching...");
        return this;
    }

    /**
     * Step: Verify user-profile section name value
     * @param profileName
     * @return SiteProfilePage
     */
    public SiteProfilePage check_Validate_UserProfile_Name(String profileName){
        siteHeaderPanel.action_Validate_UserProfile_Name(profileName);
        return this;
    }

    /**
     * Step: Perform sign-out button if button available
     * @return SiteLoginPage
     */
    public SiteLoginPage step_Perform_SignOut_Button_If_Available() throws ScriptException, ApplicationException {
        siteHeaderPanel.action_Perform_SignOut_Button();
        return new SiteLoginPage(driver);
    }

    /**
     * Step: Navigate main menu for women section
     * @return SiteBrowsPage
     */
    public SiteBrowsPage step_Navigate_Woman_Collection_Using_MainMenu() throws ScriptException, ApplicationException {
        siteHeaderPanel.action_Navigate_Woman_Collection_Using_MainMenu();
        return new SiteBrowsPage(driver);
    }

    /**
     * Step: Verify logged profile name
     * @return SiteProfilePage
     */
    public SiteProfilePage check_And_Validate_ProfileName(){

        return this;
    }
}
