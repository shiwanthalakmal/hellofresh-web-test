package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteBillingAddressPage extends PageObject {

    private By btn_proceedAddress  = By.name("processAddress");

    SiteHeaderPanel siteHeaderPanel;

    public SiteBillingAddressPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteShippingAddressPage step_Proceed_With_Default_Billing_Address(){
        driver.findElement(btn_proceedAddress).click();
        return new SiteShippingAddressPage(driver);
    }


}
