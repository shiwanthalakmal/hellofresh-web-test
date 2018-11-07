package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteBrowsPage extends BasePage {

    private By lnk_itemSelection = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
    private By btn_moreDetails   = By.xpath("//a[@title='View']");

    SiteHeaderPanel siteHeaderPanel;

    public SiteBrowsPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Browse and select random item for buy
     * @return SiteDetailPage
     */
    public SiteDetailPage step_Select_Random_Item_And_MoveTo_Detail_View() throws ScriptException, ApplicationException {
        link(lnk_itemSelection).click();
        button(btn_moreDetails).click();
        return new SiteDetailPage(driver);
    }

}
