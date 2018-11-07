package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteHomePage extends PageObject {

    SiteHeaderPanel siteHeaderPanel;

    public SiteHomePage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Perform sign-in button to access
     * @return SiteLoginPage
     */
    public SiteLoginPage step_Perform_SingIn_Button(){
        siteHeaderPanel.action_Perform_SingIn_Button();
        return new SiteLoginPage(driver);
    }

}
