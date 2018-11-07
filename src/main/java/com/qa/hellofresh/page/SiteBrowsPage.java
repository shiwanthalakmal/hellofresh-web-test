package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteBrowsPage extends PageObject {

    private By lnk_itemSelection = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
    private By btn_moreDetails   = By.xpath("//a[@title='View']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteBrowsPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteDetailPage step_Select_Random_Item_And_MoveTo_Detail_View(){
        driver.findElement(lnk_itemSelection).click();
        driver.findElement(btn_moreDetails).click();
        return new SiteDetailPage(driver);
    }

}
