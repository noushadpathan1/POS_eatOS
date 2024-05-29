package com.qa.pages;

import com.qa.stepdef.MenuManagementStepDef;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RestaurantScreen extends BasePage{

    LoginScreen loginScreen = new LoginScreen();
    NewOrderScreen newOrderScreen = new NewOrderScreen();
    MenuManagementScreen menuManagement = new MenuManagementScreen();

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Restaurant')]")
    private WebElement restaurant;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='New Customer']/android.widget.ImageView")
    private WebElement closeDialogRestaurant;
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    private WebElement closeDialogRes;


    public void onRestaurant() {


        int maxAttempts = 10;
        int currentAttempt = 1;

        while (currentAttempt <= maxAttempts) {
            try {
                if (currentAttempt == 1) {
                    loginScreen.login("np3@eigital.com", "@Password123");
                    loginScreen.pressLoginBtn();
                    loginScreen.enterLoginPin();
                } else {
                    loginScreen.enterLoginPin();
                }
                break;
            } catch (Exception e) {
                System.out.println("Attempt " + currentAttempt + ": Exception occurred: " + e.getClass().getSimpleName());
                currentAttempt++;
            }
        }

        clickOnElement(newOrderScreen.newOrderModule);
        waitForVisibility(menuManagement.topDropDown);
        clickOnElement(menuManagement.topDropDown);
        clickOnElement(restaurant);
    }

    // GuestBook

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Guestbook']")
    private WebElement guestbook;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Jhon']")
    private WebElement guestbookNameField;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'first name')]")
    private WebElement emptyGuestbookNameErrMsg;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'phone number')]")
    private WebElement emptyGuestbookPhNumErrMsg;

    @AndroidFindBy(xpath = "//android.view.View[@bounds='[1638,279][1677,317]']")
    private WebElement searchBarIconGuestbook;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'alex Jhonny')]")
    private WebElement guestbookFirstField;


    public void addGuestBookDetails(String val){
        clickOnElement(guestbook);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagement.ADD);

        switch (val) {
            case "ValidGuestbookDetails" -> {
                clickOnElement(guestbookNameField);
                typeTextIntoElement(guestbookNameField, "testGuestName");
            }
            case "EmptyGuestbookName" -> clickOnElement(guestbookNameField);
            case "EmptyGuestbookNum" -> {
                clickOnElement(guestbookNameField);
                typeTextIntoElement(guestbookNameField, "1234", "testGuestBook");
            }
        }
        clickOnElement(closeDialogRestaurant);
    }
    public void getGuestBookErrorMsg(String val){
        if(val.equals("ValidGuestbookDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyGuestbookName")) {
            Assert.assertTrue(emptyGuestbookNameErrMsg.isDisplayed());
        }
        else if (val.equalsIgnoreCase("EmptyGuestbookNum")) {
            //Assert.assertTrue(emptyGuestbookPhNumErrMsg.isDisplayed());
        }
    }

    public void searchGuestBook(){
        clickOnElement(guestbook);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconGuestbook);
        clickOnElement(menuManagement.searchBar);
        clearText(menuManagement.searchBar);
        typeTextIntoElement(menuManagement.searchBar,"alex Jhonny");
    }

    public void validateSearchGuestBook(){
        Assert.assertTrue(guestbookFirstField.isDisplayed());
    }

    // Schedule Info

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Schedule Info']")
    private WebElement scheduleInfo;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Jhon']")
    private WebElement scheduleInfoNameField;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'first name')]")
    private WebElement emptyScheduleInfoNameErrMsg;

    @AndroidFindBy(xpath = "(//android.view.View)[33]")
    private WebElement searchBarIconScheduleInfo;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Schedule one')]")
    private WebElement scheduleInfoFirstField;




    public void addScheduleInfoDetails(String val){
        clickOnElement(scheduleInfo);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagement.ADD);

        switch (val) {
            case "ValidScheduleInfoDetails" -> {
                clickOnElement(scheduleInfoNameField);
                typeTextIntoElement(scheduleInfoNameField, "test");
            }
            case "EmptyScheduleInfoName" -> clickOnElement(scheduleInfoNameField);
        }
        clickOnElement(closeDialogRes);
    }
    public void getScheduleInfoErrorMsg(String val){
        if(val.equals("ValidScheduleInfoDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyScheduleInfoName")) {
            Assert.assertTrue(emptyScheduleInfoNameErrMsg.isDisplayed());
        }
    }

    public void searchScheduleInfo(){
        clickOnElement(scheduleInfo);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconScheduleInfo);
        clickOnElement(menuManagement.searchBar);
        clearText(menuManagement.searchBar);
        typeTextIntoElement(menuManagement.searchBar,"Schedule one");
    }

    public void validateSearchScheduleInfo(){
        Assert.assertTrue(scheduleInfoFirstField.isDisplayed());
    }


    // Timed Pricing

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Timed Pricing']")
    private WebElement timedPricing;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Timed Pricing Name']")
    private WebElement timedPricingNameField;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Special Event Name cannot be empty')]")
    private WebElement emptyTimedPricingNameErrMsg;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'TIMED PRICING')]/android.view.View[1]")
    private WebElement searchBarIconTimedPricing;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Test One')]")
    private WebElement timedPricingFirstField;

    public void addTimedPricingDetails(String val){
        clickOnElement(timedPricing);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagement.ADD);

        switch (val) {
            case "ValidTimedPricingDetails" -> {
                clickOnElement(timedPricingNameField);
                typeTextIntoElement(timedPricingNameField, "testGuestName");
            }
            case "EmptyTimedPricingName" -> clickOnElement(timedPricingNameField);
        }
        clickOnElement(closeDialogRes);
    }
    public void getTimedPricingErrorMsg(String val){
        if(val.equals("ValidTimedPricingDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyTimedPricingName")) {
            Assert.assertTrue(emptyTimedPricingNameErrMsg.isDisplayed());
        }
    }

    public void searchTimedPricing(){
        clickOnElement(timedPricing);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconTimedPricing);
        clickOnElement(menuManagement.searchBar);
        clearText(menuManagement.searchBar);
        typeTextIntoElement(menuManagement.searchBar,"Test One");
    }

    public void validateSearchTimedPricing(){
      //  Assert.assertTrue(timedPricingFirstField.isDisplayed());
    }





}
