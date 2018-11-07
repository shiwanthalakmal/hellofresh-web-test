package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteDetailPage extends PageObject {

    private By btn_itemSubmit                  = By.name("Submit");
    private By btn_overlayProceedToCheckout    = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteDetailPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteDetailPage step_AddTo_Cart_SelectedItem(){
        driver.findElement(btn_itemSubmit).click();
        return this;
    }

    public SiteShoppingCartPage step_Item_ProceedTo_Checkout(){
        driver.findElement(btn_overlayProceedToCheckout).click();
        return new SiteShoppingCartPage(driver);
    }


}
