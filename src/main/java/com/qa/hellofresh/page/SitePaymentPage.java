package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SitePaymentPage extends PageObject {

    private By btn_payByBankWire = By.className("bankwire");
    private By btn_confirmOrder  = By.xpath("//*[@id='cart_navigation']/button");

    SiteHeaderPanel siteHeaderPanel;

    public SitePaymentPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SitePaymentPage step_Pay_By_Bank_Wire_Process(){
        driver.findElement(btn_payByBankWire).click();
        return this;
    }

    public SiteOrderConfirmationPage step_Make_My_Order_Confirm(){
        driver.findElement(btn_confirmOrder).click();
        return new SiteOrderConfirmationPage(driver);
    }

}
