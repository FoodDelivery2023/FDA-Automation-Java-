package com.fda.MobilePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    public HomePage homePage;

    public LoginPage(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(20)), this);
        homePage = new HomePage(androidDriver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter email\")")
    private WebElement emailInputBox;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter Password\")")
    private WebElement passwordInputBox;

    @AndroidFindBy(xpath = "//*[@text='Login']/preceding-sibling::*")
    private WebElement loginButton;


    public void login(String userName, String password){
        emailInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
