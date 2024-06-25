package com.qa.pages;

import com.qa.stepdef.MenuManagementStepDef;
import com.qa.utils.PropertyManager;
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
    public WebElement guestbook;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Jhon']")
    public WebElement guestbookNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@hint,'4546566565')]")
    public WebElement guestbookPhoneNumField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"GuestBook\n" +
            "Manage your guests and view their order history and Lifetime Value\"]/android.view.View[2]")
    public WebElement guestbookSearchIcon;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint=\"Search\"]")
    public WebElement guestbookTypeTextIntoSearch;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'first name')]")
    public WebElement guestbookFirstNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'phone number')]")
    public WebElement emptyGuestbookPhNumErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[@bounds='[1638,279][1677,317]']")
    public WebElement searchBarIconGuestbook;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'guestOne')]")
    public WebElement guestbookFirstField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'guestOne')]/android.view.View")
    public WebElement guestbookArchiveBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='1.  Please add Guest's Email or Phone number']")
    public WebElement EmptyFirstNameAndPhNumErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Archive']")
    public WebElement guestbookArchive;


    public void addGuestBookDetails(String val){
        clickOnElement(guestbook);
        threadSleep(1000);
        clickOnElement(menuManagement.ADD);

        switch (val) {
            case "EmptyGuestbookDetails" -> {
                clickOnElement(guestbookNameField);
                clickOnElement(closeDialogRes);
            }

            case "MandatoryGuestbookDetails" -> {
                clickOnElement(guestbookNameField);
                typeTextIntoElement(guestbookNameField, PropertyManager.getProperty("guestbookNameField"));
                clickOnElement(guestbookPhoneNumField);
                clickOnElement(guestbookPhoneNumField,PropertyManager.getProperty("guestbookPhoneNumField"));
                clickOnElement(closeDialogRes);
            }
            case "SearchGuestbook" -> {
                clickOnElement(guestbookSearchIcon);
                typeTextIntoElement(guestbookTypeTextIntoSearch,PropertyManager.getProperty("guestbookNameField"));
            }
            case "ArchiveGuestbook" -> {
                clickOnElement(guestbookSearchIcon);
                typeTextIntoElement(guestbookTypeTextIntoSearch,PropertyManager.getProperty("guestbookNameField"));
                waitForVisibility(guestbookFirstField);
                clickOnElement(guestbookArchiveBtn);
                clickOnElement(guestbookArchive);
            }
        }
    }
    public void getGuestBookErrorMsg(String val){
        if(val.equals("EmptyGuestbookDetails")){
            Assert.assertTrue(EmptyFirstNameAndPhNumErrMsg.isDisplayed());
        }else if (val.equalsIgnoreCase("MandatoryGuestbookDetails")) {
            Assert.assertTrue(guestbookFirstField.isDisplayed());
        }else if (val.equalsIgnoreCase("SearchGuestbook")) {
            Assert.assertTrue(guestbookFirstField.isDisplayed());
        }else if (val.equalsIgnoreCase("ArchiveGuestbook")) {
            Assert.assertTrue(guestbookFirstField.isDisplayed());
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
