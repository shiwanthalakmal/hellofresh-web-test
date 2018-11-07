package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteOrderConfirmationPage extends BasePage {

    private By lbl_confirmationTitle = By.cssSelector("h1");
    private By lbl_orderOnStore      = By.xpath("//*[@class='cheque-indent']/strong");

    private By btn_forthBreadcrumb   = By.xpath("//li[@class='step_done step_done_last four']");
    private By btn_fifthBreadcrumb   = By.xpath("//li[@id='step_end' and @class='step_current last']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteOrderConfirmationPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Verify current page url
     * @param url
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_Current_URLContains(String url){
        verifyTrue(driver.getCurrentUrl().contains(url), "Error ! URL does not matching ..");
        return this;
    }

    /**
     * Step: Verify order confirmation title message
     * @param title
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_OrderConfirmation_Title(String title) throws ScriptException, ApplicationException {
        verifyEquals(label(lbl_confirmationTitle).getText(), title, "Error ! Confirmation title does not matching ..");
        return this;
    }

    /**
     * Step: Verify order on store available message
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_OrderOnStore_Message() throws ScriptException, ApplicationException {
        verifyTrue(label(lbl_orderOnStore).getText().contains("Your order on My Store is complete."), "Error ! Order on store message does not matching ..");
        return this;
    }

    /**
     * Step: Verify previous breadcrumb availability
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage check_And_Validate_Breadcrumb_Availability(){
        verifyTrue(driver.findElement(btn_forthBreadcrumb).isDisplayed(),"Error ! Fourth breadcrumb is not available");
        verifyTrue(driver.findElement(btn_fifthBreadcrumb).isDisplayed(),"Error ! Fifth breadcrumb is not available");
        return this;
    }

}
