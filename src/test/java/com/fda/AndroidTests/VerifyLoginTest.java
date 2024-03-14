package com.fda.AndroidTests;

import com.fda.Automation.FDABase;
import com.fda.MobilePages.HomePage;
import com.fda.MobilePages.LoginPage;
import com.fda.MobilePages.OrderPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLoginTest extends FDABase {

    public HomePage homePage;
    public LoginPage loginPage;

    public OrderPage orderPage;
    @BeforeClass
    public void initializePages(){
        homePage = new HomePage(androidDriver);
        loginPage = new LoginPage(androidDriver);
        orderPage = new OrderPage(androidDriver);

    }
    @Test
    public void verifySuccessfulLogin() throws InterruptedException {
        Thread.sleep(5000);
        homePage.tapOnLoginButton();
        loginPage.login("parthu.y@gmail.com","Pass@123");
        //orderPage.Order();
        orderPage.Item();
        orderPage.menuitem();
        orderPage.placeOrderPendingvalidation();
    }
}
