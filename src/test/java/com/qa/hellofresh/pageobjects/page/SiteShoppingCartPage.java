package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteShoppingCartPage extends BasePage {

    private By btn_cartProceedToCheckout  = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteShoppingCartPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Perform shopping cart final checkout
     * @return SiteBillingAddressPage
     */
    public SiteBillingAddressPage step_Item_ProceedTo_ShoppingCart_Checkout() throws ScriptException, ApplicationException {
        button(btn_cartProceedToCheckout).click();
        return new SiteBillingAddressPage(driver);
    }


}
