package com.fda.Automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FDABase {
    public AndroidDriver androidDriver;

    @BeforeSuite
    public void launchApplication() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Samsung");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13.0");
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setNewCommandTimeout(Duration.ofSeconds(60));
        uiAutomator2Options.setApp(System.getProperty("user.dir")+"/fda.apk");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
