package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteShippingAddressPage extends PageObject {

    private By chkBx_agreement = By.id("uniform-cgv");
    private By btn_proceedAddress  = By.name("processCarrier");

    SiteHeaderPanel siteHeaderPanel;

    public SiteShippingAddressPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteShippingAddressPage step_Agreement_MakeAgree(){
        driver.findElement(chkBx_agreement).click();
        return this;
    }

    public SitePaymentPage step_Proceed_With_Default_Shipping_Address(){
        driver.findElement(btn_proceedAddress).click();
        return new SitePaymentPage(driver);
    }


}
