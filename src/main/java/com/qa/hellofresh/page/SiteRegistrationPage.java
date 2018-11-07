package com.qa.hellofresh.page;

import com.qa.hellofresh.base.PageObject;
import com.qa.hellofresh.panel.SiteHeaderPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SiteRegistrationPage extends PageObject {

    private By rdoBtn_Gender    = By.id("id_gender2");
    private By txtFld_Fname     = By.id("customer_firstname");
    private By txtFld_Lname     = By.id("customer_lastname");
    private By txtFld_Password  = By.id("passwd");

    private By ddl_Birth_Date   = By.id("days");
    private By ddl_Birth_Month  = By.id("months");
    private By ddl_Birth_Year   = By.id("years");

    private By txtFld_Company   = By.id("company");
    private By txtFld_Addre01   = By.id("address1");
    private By txtFld_Addre02   = By.id("address2");
    private By txtFld_City      = By.id("city");
    private By ddl_State        = By.id("id_state");
    private By txtFld_Postal    = By.id("postcode");
    private By txtArea_AddiInfo = By.id("other");
    private By txtFld_landPhone = By.id("phone");
    private By txtFld_mobilePhon= By.id("phone_mobile");
    private By txtFld_alias     = By.id("alias");

    private By btn_SubmitAccount= By.id("submitAccount");

    SiteHeaderPanel siteHeaderPanel;

    public SiteRegistrationPage(RemoteWebDriver driver) {
        super(driver);
        this.siteHeaderPanel = new SiteHeaderPanel(driver);
    }

    public SiteRegistrationPage step_Enter_Personal_Information(){
        driver.findElement(rdoBtn_Gender).click();
        driver.findElement(txtFld_Fname).sendKeys(faker.name().firstName());
        driver.findElement(txtFld_Lname).sendKeys(faker.name().lastName());
        driver.findElement(txtFld_Password).sendKeys(faker.name().firstName()+""+String.valueOf(faker.number().numberBetween(100,999)));

        Select select = new Select(driver.findElement(ddl_Birth_Date));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1,30)));
        select = new Select(driver.findElement(ddl_Birth_Month));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1,12)));
        select = new Select(driver.findElement(ddl_Birth_Year));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1980,2000)));

        return this;
    }

    public SiteRegistrationPage step_Enter_Address_Information(){
        driver.findElement(txtFld_Company).sendKeys(faker.company().name());
        driver.findElement(txtFld_Addre01).sendKeys(faker.company().name()+" "+faker.number().numberBetween(1,100));
        driver.findElement(txtFld_Addre02).sendKeys(faker.address().buildingNumber());
        driver.findElement(txtFld_City).sendKeys(faker.address().cityName());

        Select select = new Select(driver.findElement(ddl_State));
        select.selectByVisibleText("Colorado");
        driver.findElement(txtFld_Postal).sendKeys(String.valueOf(faker.number().numberBetween(10000,99999)));
        driver.findElement(txtArea_AddiInfo).sendKeys("I m Fine Thank you !");
        driver.findElement(txtFld_landPhone).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(txtFld_mobilePhon).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(txtFld_alias).sendKeys(faker.idNumber().ssnValid());
        return this;
    }

    public SiteProfilePage step_Submit_Account_Details(){
        driver.findElement(btn_SubmitAccount).click();
        return new SiteProfilePage(driver);
    }
}
