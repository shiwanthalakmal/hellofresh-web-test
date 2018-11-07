package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteBillingAddressPage extends BasePage {

    private By btn_proceedAddress  = By.name("processAddress");

    SiteHeaderPanel siteHeaderPanel;

    public SiteBillingAddressPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Checkout proceed with default billing address
     * @return SiteShippingAddressPage
     */
    public SiteShippingAddressPage step_Proceed_With_Default_Billing_Address() throws ScriptException, ApplicationException {
        button(btn_proceedAddress).click();
        return new SiteShippingAddressPage(driver);
    }


}
