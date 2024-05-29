package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NewOrderScreen extends BasePage{

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Ver')]")
    public WebElement newOrderModule;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[1]")
    private WebElement product;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"1 item\n" +
            " $11.00\"]")
    private WebElement items;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CHARGE $21.00\"]")
    private WebElement CHARGE;
    @AndroidFindBy(xpath = "//android.widget.Button")
    private WebElement backButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Tickets\n" +
            "Tab 2 of 4\"]")
    private WebElement tickets;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"20\n" +
            "Guest\n" +
            "Arrived At: 1:28 PM\n" +
            "PAID\"]")
    private WebElement latestTicket;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Guest Name']")
    private WebElement guestName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='(XXX) XXX-XXXX']")
    private WebElement phoneNum;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"FIRE\"]")
    private WebElement fireBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Payment\n" +
            "Total Due $21.00\"]/android.view.View[1]")
    private WebElement dismissBtn;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Login Manager\n" +
            "You are not clocked in\"]")
    public WebElement empName;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@index='8'])[1]")
    private WebElement newOrder;


    public void enterGuestDetails(){
        clickOnElement(guestName);
        typeTextIntoElement(guestName,"Noushad");
        clickOnElement(phoneNum);
        typeTextIntoElement(phoneNum,"79878988777");
        clickOnElement(product);
        clickOnElement(items);
        clickOnElement(fireBtn);
        clickOnElement(dismissBtn);
        clickOnElement(tickets);

    }
    public void checkGuestDetails(){

    }

    public void productsField(){
        clickOnElement(product);
        clickOnElement(items);
        clickOnElement(CHARGE);
       // waitForVisibility(CHARGE);

    }
    public void verifyTicketStatus(){
//        clickOnElement(CHARGE);
//        clickOnElement(backButton);
//        clickOnElement(tickets);
//        clickOnElement(latestTicket);
    }
}
