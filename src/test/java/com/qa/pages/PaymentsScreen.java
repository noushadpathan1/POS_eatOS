package com.qa.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaymentsScreen extends BasePage {
    MenuManagementScreen menuManagementScreen = new MenuManagementScreen();
    LoginScreen loginScreen = new LoginScreen();
    NewOrderScreen newOrderScreen = new NewOrderScreen();

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Payment')]")
    private WebElement payments;
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,'ARCHIVE')])/android.view.View[1]")
    private WebElement SearchBarPayments;

    public void onPayments() {

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
        waitForVisibility(menuManagementScreen.topDropDown);
        clickOnElement(menuManagementScreen.topDropDown);
        clickOnElement(payments);
    }


    //---> Taxes

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Taxes']")
    private WebElement taxes;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Tax Name']")
    private WebElement taxNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='0.00']")
    private WebElement taxAmountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='SAVE']")
    public WebElement SAVE;

    @AndroidFindBy(xpath = "//android.widget.Toast[contains(@text,'Amount can')]")
    private WebElement emptyTaxAmountErrMsg;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Please set a name']")
    private WebElement pleaseSetANameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Sales Tax')]")
    private WebElement taxFirstField;



    public void addTaxDetails(String val){
        clickOnElement(taxes);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagementScreen.ADD);

        if(val.equalsIgnoreCase("ValidTaxDetails")){
            clickOnElement(taxNameField);
            typeTextIntoElement(taxNameField,"taxOne");
            clickOnElement(taxAmountField);
            typeTextIntoElement(taxAmountField,"1000");

        } else if (val.equalsIgnoreCase("EmptyTaxName")) {

            clickOnElement(taxAmountField);
            typeTextIntoElement(taxAmountField,"1000");
        } else if (val.equalsIgnoreCase("EmptyTaxAmount")) {

            clickOnElement(taxNameField);
            typeTextIntoElement(taxNameField,"taxOne");
        } else if (val.equalsIgnoreCase("EmptyAllFields")) {

            clickOnElement(taxNameField);
        }clickOnElement(SAVE);
    }
    public void taxesErrMsg(String val){

        if(val.equalsIgnoreCase("ValidTaxDetails")){


        } else if (val.equalsIgnoreCase("EmptyTaxName")) {

            String Expected ="Please set a name";
            Assert.assertEquals(Expected,pleaseSetANameErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyTaxAmount")) {

            String Expected ="Amount can't be 0";
            Assert.assertEquals(Expected,emptyTaxAmountErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyAllFields")) {

            String Expected ="Please set a name";
            Assert.assertEquals(Expected,pleaseSetANameErrMsg.getText());
        }
    }

    public void searchTax(){

        clickOnElement(taxes);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(SearchBarPayments);
        clickOnElement(menuManagementScreen.searchBar);
        clearText(menuManagementScreen.searchBar);
        typeTextIntoElement(menuManagementScreen.searchBar,"Sales Tax");
    }
    public void validateSearchTax(){
  //      Assert.assertTrue(taxFirstField.isDisplayed());
    }

    //---> Discounts

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Discounts']")
    private WebElement discounts;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Discount Name']")
    private WebElement discountNameField;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Please set a value larger than 0']")
    private WebElement discountAmountErrMsg;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'0.00')]")
    private WebElement discountAmountField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Sales discount')]")
    private WebElement discountFirstField;

    public void addDiscountDetails(String val){
        clickOnElement(discounts);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagementScreen.ADD);

        if(val.equalsIgnoreCase("ValidDiscountDetails")){
            clickOnElement(discountNameField);
            typeTextIntoElement(discountNameField,"discountOne");
            clickOnElement(discountAmountField);
            typeTextIntoElement(discountAmountField,"1000");

        } else if (val.equalsIgnoreCase("EmptyDiscountName")) {

            clickOnElement(discountAmountField);
            typeTextIntoElement(discountAmountField,"1000");
        } else if (val.equalsIgnoreCase("EmptyDiscountAmount")) {

            clickOnElement(discountNameField);
            typeTextIntoElement(discountNameField,"discountOne");
        } else if (val.equalsIgnoreCase("EmptyAllFields")) {

            clickOnElement(discountNameField);
        }clickOnElement(SAVE);
    }
    public void discountsErrMsg(String val){

        if(val.equalsIgnoreCase("ValidDiscountDetails")){

        } else if (val.equalsIgnoreCase("EmptyDiscountName")) {

         //   String Expected ="Please set a name";
         //   Assert.assertEquals(Expected,pleaseSetANameErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyDiscountAmount")) {

//            String Expected ="Please set a value larger than 0";
//            Assert.assertEquals(Expected,discountAmountErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyAllFields")) {

//            String Expected ="Please set a name";
//            Assert.assertEquals(Expected,pleaseSetANameErrMsg.getText());
        }
    }
    public void searchDiscount(){

        clickOnElement(discounts);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(SearchBarPayments);
        clickOnElement(menuManagementScreen.searchBar);
        clearText(menuManagementScreen.searchBar);
        typeTextIntoElement(menuManagementScreen.searchBar,"Sales discount");
    }
    public void validateSearchDiscount(){
        Assert.assertTrue(discountFirstField.isDisplayed());
    }

    //---> Service Charge

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Service Charge']")
    private WebElement serviceCharge;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Service Charge Name']")
    private WebElement serviceChargeNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'0.00')]")
    private WebElement serviceChargeAmountField;
    @AndroidFindBy(xpath = "//android.widget.Toast[contains(@text='Please set a valid amount')]")
    private WebElement emptyServiceChargeAmountErrMsg;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Please set name']")
    private WebElement pleaseSetNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Delivery charge')]")
    private WebElement serviceChargeFirstField;

    public void addServiceChargeDetails(String val){
        clickOnElement(serviceCharge);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagementScreen.ADD);

        if(val.equalsIgnoreCase("ValidServiceChargeDetails")){

            clickOnElement(serviceChargeNameField);
            typeTextIntoElement(serviceChargeAmountField,"serviceOne");
            clickOnElement(serviceChargeAmountField);
            typeTextIntoElement(serviceChargeAmountField,"1000");

        } else if (val.equalsIgnoreCase("EmptyServiceChargeName")) {

            clickOnElement(serviceChargeAmountField);
            typeTextIntoElement(serviceChargeAmountField,"1000");
        } else if (val.equalsIgnoreCase("EmptyServiceChargeAmount")) {

            clickOnElement(serviceChargeNameField);
            typeTextIntoElement(serviceChargeAmountField,"serviceOne");
        } else if (val.equalsIgnoreCase("EmptyAllFields")) {

            clickOnElement(serviceChargeNameField);
        }
        clickOnElement(SAVE);
    }
    public void serviceChargeErrMsg(String val){

        if(val.equalsIgnoreCase("ValidServiceChargeDetails")){

        } else if (val.equalsIgnoreCase("EmptyServiceChargeName")) {

            String Expected ="Please set name";
            Assert.assertEquals(Expected,pleaseSetNameErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyServiceChargeAmount")) {

//            String Expected ="Please set a valid amount";
//            Assert.assertEquals(Expected,emptyServiceChargeAmountErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyAllFields")) {

            String Expected ="Please set name";
            Assert.assertEquals(Expected,pleaseSetNameErrMsg.getText());
        }
    }
    public void searchServiceCharge(){

        clickOnElement(serviceCharge);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(SearchBarPayments);
        clickOnElement(menuManagementScreen.searchBar);
        clearText(menuManagementScreen.searchBar);
        typeTextIntoElement(menuManagementScreen.searchBar,"Delivery charge");
    }
    public void validateSearchServiceCharge(){
        Assert.assertTrue(serviceChargeFirstField.isDisplayed());
    }
}
