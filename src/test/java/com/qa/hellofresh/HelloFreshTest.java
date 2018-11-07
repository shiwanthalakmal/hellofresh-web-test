package com.qa.hellofresh;


import com.qa.hellofresh.base.BaseTest;
import com.qa.hellofresh.page.SiteHomePage;
import org.testng.annotations.Test;

public class HelloFreshTest extends BaseTest
{

    @Test(groups = {"BAT"})
    public void site_user_registration_functionality_test()
    {
        new SiteHomePage(getDriver()).step_Perform_SingIn_Button().
                step_Create_New_Account_Using_Email().
                step_Enter_Personal_Information().
                step_Enter_Address_Information().
                step_Submit_Account_Details().
                check_And_Validate_MyAccount_Title("MY ACCOUNT").
                check_And_Validate_ProfileName().
                check_And_Validate_Welcome_Message().
                check_And_Validate_Current_URLContains("controller=my-account").
                step_Perform_SignOut_Button_If_Available();
    }

    @Test(groups = {"BAT"})
    public void site_basic_login_functionality_test()
    {
        new SiteHomePage(getDriver()).step_Perform_SingIn_Button().
                step_Enter_Login_Credentials("hf_challenge_123456@hf12345.com", "12345678").
                check_And_Validate_MyAccount_Title("MY ACCOUNT").
                check_Validate_UserProfile_Name("Joe Black").
                check_And_Validate_Welcome_Message().
                check_And_Validate_Current_URLContains("controller=my-account").
                step_Perform_SignOut_Button_If_Available();
    }

    @Test(groups = {"BAT"})
    public void site_item_checkout_functionality_test()
    {
        new SiteHomePage(getDriver()).step_Perform_SingIn_Button().
                step_Enter_Login_Credentials("hf_challenge_123456@hf12345.com", "12345678").
                step_Navigate_Woman_Collection_Using_MainMenu().
                step_Select_Random_Item_And_MoveTo_Detail_View().
                step_AddTo_Cart_SelectedItem().
                step_Item_ProceedTo_Checkout().
                step_Item_ProceedTo_ShoppingCart_Checkout().
                step_Proceed_With_Default_Billing_Address().
                step_Agreement_MakeAgree().step_Proceed_With_Default_Shipping_Address().
                step_Pay_By_Bank_Wire_Process().step_Make_My_Order_Confirm().
                check_And_Validate_OrderConfirmation_Title("ORDER CONFIRMATION").
                check_And_Validate_OrderOnStore_Message().
                check_And_Validate_Breadcrumb_Availability().
                check_And_Validate_Current_URLContains("controller=order-confirmation");
    }
}
