package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteShoppingCartPage extends PageObject {

    private By btn_cartProceedToCheckout  = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteShoppingCartPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteBillingAddressPage step_Item_ProceedTo_ShoppingCart_Checkout(){
        driver.findElement(btn_cartProceedToCheckout).click();
        return new SiteBillingAddressPage(driver);
    }


}
