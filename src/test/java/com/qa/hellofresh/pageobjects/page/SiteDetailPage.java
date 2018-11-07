package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteDetailPage extends BasePage {

    private By btn_itemSubmit                  = By.name("Submit");
    private By btn_overlayProceedToCheckout    = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteDetailPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Select and move to add to cart
     * @return SiteDetailPage
     */
    public SiteDetailPage step_AddTo_Cart_SelectedItem() throws ScriptException, ApplicationException {
        button(btn_itemSubmit).click();
        return this;
    }

    /**
     * Step: Selected item move to initial checkout process
     * @return SiteShoppingCartPage
     */
    public SiteShoppingCartPage step_Item_ProceedTo_Checkout() throws ScriptException, ApplicationException {
        button(btn_overlayProceedToCheckout).click();
        return new SiteShoppingCartPage(driver);
    }


}
