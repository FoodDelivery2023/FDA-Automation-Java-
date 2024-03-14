package com.fda.MobilePages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public class OrderPage {

    public OrderPage(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(20)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter email\")")
    private WebElement emailInputBox;

    //select restaurant Mehfil
    //@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Mehfil new, 4\"]/android.widget.ImageView")
    //private WebElement restaurant;


   //public void Order() {
        //restaurant.click();

    //}
    // menu Iteam Mehifil

    //@AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD'])[1]")
    //private WebElement item;

   //@AndroidFindBy(xpath = "(//android.widget.TextView[@text='ADD'])[2]")
   //private WebElement item;

   @AndroidFindBy(xpath = "//android.widget.EditText[@text='Find your favourite delicacy']")
   private WebElement Searchoption;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> restlist;
    public void Item() throws InterruptedException {

        Searchoption.sendKeys("Mehfil");
        Thread.sleep(5000);
        System.out.println("..."+restlist.size());
        for(int i=0;i< restlist.size();i++){
            if ((restlist.get(i).getText()).contains("Mehfil new")){
                restlist.get(i).click();
            }
        }


    }


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='ADD']")
    private WebElement Addbutton;


    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> menulist;

    @AndroidFindBy(xpath="(//android.view.ViewGroup//android.view.ViewGroup//android.widget.ImageView)[8]")
    private WebElement cartbutton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='+']")
    private WebElement addSymbol;

    @AndroidFindBy(xpath="//*[@resource-id='chip-container'][2]")
    private WebElement couponbutton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Apply']")
    private WebElement Applybutton;

    @AndroidFindBy(xpath="//android.widget.TextView")
    private List<WebElement> coupons;

    @AndroidFindBy(xpath = "//*[@content-desc='Place Order']")
    private WebElement placeorderbutton;

    @AndroidFindBy(xpath = "//*[@content-desc='Orders']")
    private WebElement OrderTab;

    @AndroidFindBy(xpath = "//*[@content-desc='Orders']")
    private WebElement Ordersmenu;


    @AndroidFindBy(xpath="(//android.widget.TextView)[27]")
    private WebElement textvalidation;
    public void menuitem() throws InterruptedException {
        Thread.sleep(5000);

        System.out.println("..."+menulist.size());
        for(int i=0;i< menulist.size();i++){
            System.out.println("..."+menulist.get(i).getText());
            if ((menulist.get(i).getText()).contains("CB")) {
                Addbutton.click();
                addSymbol.click();
                break;
            }

        }
        Thread.sleep(2000);
        cartbutton.click();
        Thread.sleep(2000);
        couponbutton.click();
        System.out.println("..."+coupons.size());
        for(int i=0;i< coupons.size();i++){
            System.out.println("..."+coupons.get(i).getText());
            if ((coupons.get(i).getText()).contains("You Will get Flat Rs.80")) {
                Applybutton.click();
                break;
            }

        }
placeorderbutton.click();
        OrderTab.click();
        Thread.sleep(4000);
        Ordersmenu.click();
        Thread.sleep(2000);

           }




           public void placeOrderPendingvalidation() {
               String Actualtext = textvalidation.getText();
               if (Actualtext == "Past Order is Pending") {
                   //String Actualtext=textvalidation.getText();
                   String expectedText = "Past Order is Pending";
                   Assert.assertEquals(Actualtext, expectedText);
               } else {
                   System.out.println("place odrder pending is not available");
               }
           }
}
