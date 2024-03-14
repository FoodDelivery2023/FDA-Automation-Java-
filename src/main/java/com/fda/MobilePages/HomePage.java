package com.fda.MobilePages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    private AndroidDriver androidDriver;

    public HomePage(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(20)), this);
        this.androidDriver = androidDriver;
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginButton;

    public WebElement getLoginButton(){
        return loginButton;
    }
    public void tapOnLoginButton() {
        //androidDriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Login\")")).click();
        loginButton.click();
    }
}
