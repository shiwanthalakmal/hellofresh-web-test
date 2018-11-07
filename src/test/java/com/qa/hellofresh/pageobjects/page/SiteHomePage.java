package com.qa.hellofresh.pageobjects.page;

import com.qa.hellofresh.base.BasePage;
import com.qa.hellofresh.exception.ApplicationException;
import com.qa.hellofresh.exception.ScriptException;
import com.qa.hellofresh.pageobjects.panel.SiteHeaderPanel;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SiteHomePage extends BasePage {

    SiteHeaderPanel siteHeaderPanel;

    public SiteHomePage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    /**
     * Step: Perform sign-in button to access
     * @return SiteLoginPage
     */
    public SiteLoginPage step_Perform_SingIn_Button() throws ScriptException, ApplicationException {
        siteHeaderPanel.action_Perform_SingIn_Button();
        return new SiteLoginPage(driver);
    }

}
