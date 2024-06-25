package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WorkforceScreen extends BasePage {
    LoginScreen loginScreen = new LoginScreen();
    NewOrderScreen newOrderScreen  = new NewOrderScreen();
    MenuManagementScreen menuManagementScreen = new MenuManagementScreen();
    PaymentsScreen paymentsScreen = new PaymentsScreen();

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Workforce')]")
    private WebElement workforce;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='First Name']")
    private WebElement employeeFirstNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Last Name']")
    private WebElement employeeLastNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Employee Email']")
    private WebElement employeeEmailField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Employee Phone Number']")
    private WebElement employeePhoneNumField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Employee Id']")
    private WebElement employeeIDField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CREATE NEW PIN']")
    private WebElement createNewPin;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='First Name should be set']")
    private WebElement firstNameFieldShouldSetErrMsg;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Last Name should be set']")
    private WebElement lastNameFieldShouldSetErrMsg;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Pin must be set']")
    private WebElement PinMustBeSet;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Employee Id should be set']")
    private WebElement emptyEmployeeID;


    public void onWorkforce(){

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
            clickOnElement(workforce);
        }


    public void addEmployeeDetails(String val){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagementScreen.ADD);

        if(val.equalsIgnoreCase("EmptyAllFields")){
            clickOnElement(employeeFirstNameField);

        } else if (val.equalsIgnoreCase("EmptyFirstName")) {
            clickOnElement(employeeLastNameField);
            typeTextIntoElement(employeeLastNameField,"one");
            clickOnElement(employeeEmailField);
            typeTextIntoElement(employeeEmailField,"abc@gmail.com");
            clickOnElement(employeePhoneNumField);
            typeTextIntoElement(employeePhoneNumField,"7989877889");
            clickOnElement(employeeIDField);
            typeTextIntoElement(employeeIDField,"1122");
        } else if (val.equalsIgnoreCase("EmptyLastName")) {
            clickOnElement(employeeFirstNameField);
            typeTextIntoElement(employeeFirstNameField,"employee");
            clickOnElement(employeeEmailField);
            typeTextIntoElement(employeeEmailField,"abc@gmail.com");
            clickOnElement(employeePhoneNumField);
            typeTextIntoElement(employeePhoneNumField,"7989877889");
            clickOnElement(employeeIDField);
            typeTextIntoElement(employeeIDField,"1122");
        }else if (val.equalsIgnoreCase("EmptyEmail")) {
            clickOnElement(employeeFirstNameField);
            typeTextIntoElement(employeeFirstNameField,"employee");
            clickOnElement(employeeLastNameField);
            typeTextIntoElement(employeeLastNameField,"one");
            clickOnElement(employeePhoneNumField);
            typeTextIntoElement(employeePhoneNumField,"7989877889");
            clickOnElement(employeeIDField);
            typeTextIntoElement(employeeIDField,"1122");
        }else if (val.equalsIgnoreCase("EmptyPhoneNum")) {
            clickOnElement(employeeFirstNameField);
            typeTextIntoElement(employeeFirstNameField,"employee");
            clickOnElement(employeeLastNameField);
            typeTextIntoElement(employeeLastNameField,"one");
            clickOnElement(employeeEmailField);
            typeTextIntoElement(employeeEmailField,"abc@gmail.com");
            clickOnElement(employeeIDField);
            typeTextIntoElement(employeeIDField,"1122");
        }else if (val.equalsIgnoreCase("EmptyEmpID")) {
            clickOnElement(employeeFirstNameField);
            typeTextIntoElement(employeeFirstNameField,"employee");
            clickOnElement(employeeLastNameField);
            typeTextIntoElement(employeeLastNameField,"one");
            clickOnElement(employeeEmailField);
            typeTextIntoElement(employeeEmailField,"abc@gmail.com");
            clickOnElement(employeePhoneNumField);
            typeTextIntoElement(employeePhoneNumField,"7989877889");
        }else if (val.equalsIgnoreCase("ExistingPIN")) {
            clickOnElement(employeeFirstNameField);
            typeTextIntoElement(employeeFirstNameField,"employee");
            clickOnElement(employeeLastNameField);
            typeTextIntoElement(employeeLastNameField,"one");
            clickOnElement(employeeEmailField);
            typeTextIntoElement(employeeEmailField,"abc@gmail.com");
            clickOnElement(employeePhoneNumField);
            typeTextIntoElement(employeePhoneNumField,"7989877889");
            clickOnElement(employeeIDField);
            typeTextIntoElement(employeeIDField,"1122");
        }
    }
    public void taxesErrMsg(String val) {
        clickOnElement(paymentsScreen.SAVE);

        if (val.equalsIgnoreCase("EmptyAllFields")) {

            String Expected = "First Name should be set";
            Assert.assertEquals(Expected, firstNameFieldShouldSetErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyFirstName")) {

            String Expected = "First Name should be set";
            Assert.assertEquals(Expected, firstNameFieldShouldSetErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyLastName")) {

            String Expected = "Last Name should be set";
            Assert.assertEquals(Expected, lastNameFieldShouldSetErrMsg.getText());
        } else if (val.equalsIgnoreCase("EmptyEmail")) {

            String Expected = "Pin must be set";
            Assert.assertEquals(Expected, PinMustBeSet.getText());
        } else if (val.equalsIgnoreCase("EmptyPhoneNum")) {

            String Expected = "Pin must be set";
            Assert.assertEquals(Expected, PinMustBeSet.getText());
        } else if (val.equalsIgnoreCase("EmptyEmpID")) {

            String Expected = "Employee Id should be set";
            Assert.assertEquals(Expected, emptyEmployeeID.getText());
        }
    }

    public void searchEmployee(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(menuManagementScreen.searchBar);
        clearText(menuManagementScreen.searchBar);
        typeTextIntoElement(menuManagementScreen.searchBar,"alex Jhonny");
    }

    public void validateSearchGuestBook(){
        //Assert.assertTrue(guestbookFirstField.isDisplayed());
    }
}

