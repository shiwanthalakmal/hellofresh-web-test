package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SitePaymentPage extends BasePage {

    private By btn_payByBankWire = By.className("bankwire");
    private By btn_confirmOrder  = By.xpath("//*[@id='cart_navigation']/button");

    SiteHeaderPanel siteHeaderPanel;

    public SitePaymentPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Select bank wire method as payment method
     * @return SitePaymentPage
     */
    public SitePaymentPage step_Pay_By_Bank_Wire_Process() throws ScriptException, ApplicationException {
        button(btn_payByBankWire).click();
        return this;
    }

    /**
     * Step: Make order payment confirm
     * @return SiteOrderConfirmationPage
     */
    public SiteOrderConfirmationPage step_Make_My_Order_Confirm() throws ScriptException, ApplicationException {
        button(btn_confirmOrder).click();
        return new SiteOrderConfirmationPage(driver);
    }

}
