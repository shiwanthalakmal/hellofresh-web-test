package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteLoginPage extends PageObject {

    private By txtFld_userName = By.id("email");
    private By txtFld_passWord = By.id("passwd");
    private By btn_Login = By.id("SubmitLogin");

    private By txtFld_emailAddr= By.id("email_create");
    private By btn_createAcc   = By.id("SubmitCreate");


    SiteHeaderPanel siteHeaderPanel;

    public SiteLoginPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Provide successful user login credentials and login
     * @param username
     * @param password
     * @return SiteProfilePage
     */
    public SiteProfilePage step_Enter_Login_Credentials(String username, String password){
        driver.findElement(txtFld_userName).sendKeys(username);
        driver.findElement(txtFld_passWord).sendKeys(password);
        driver.findElement(btn_Login).click();
        return new SiteProfilePage(driver);
    }

    public SiteRegistrationPage step_Create_New_Account_Using_Email(){
        driver.findElement(txtFld_emailAddr).sendKeys((faker.color().name()+"@mailinator.com").replaceAll("\\s+","") );
        driver.findElement(btn_createAcc).click();
        return new SiteRegistrationPage(driver);
    }

}
