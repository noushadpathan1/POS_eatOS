package com.qa.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MenuManagementScreen extends BasePage{

    LoginScreen loginScreen = new LoginScreen();
    NewOrderScreen newOrderScreen = new NewOrderScreen();

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='ALMOST THERE PLEASE WAIT']")
    public WebElement loadingWait;
            //(xpath = "(//android.view.View[last()]/android.widget.ImageView)[last()]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView")
    public WebElement topDropDown;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement searchBar;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Menu Management')]")
    private WebElement menuManagement;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'+ ADD')]")
    public WebElement ADD;
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    public WebElement closeDialog;

//    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Categories'])[2]/android.view.View[2]")
//    private WebElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement sendTextSearBar;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'AbcdCat')]")
    private WebElement searchSendText;


    public void emptyCategoryDetails(){
        clickOnElement(topDropDown);
        waitForVisibility(menuManagement);
        clickOnElement(menuManagement);
        clickOnElement(categories);
        clickOnElement(ADD);
        clickOnElement(categoryName);
        clickOnElement(closeDialog);
    }
    public void onMenuManagement() {

        int maxAttempts = 10;
        int currentAttempt = 1;

        while (currentAttempt <= maxAttempts) {
            try {
                if (currentAttempt == 1) {
                    loginScreen.login("np5@eigital.com","@Password123");
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
//try {
//
//    if (loginScreen.loginBtn.isDisplayed()) {
//        if(loginScreen.instaBug().isDisplayed()){
//            Thread.sleep(5000);
//        }
//        loginScreen.login("np5@eigital.com", "@Password123");
//        loginScreen.pressLoginBtn();
//        loginScreen.enterLoginPin();
//    } else {
//        loginScreen.enterLoginPin();
//    }
//}catch (Exception e) {
//    System.out.println( " Exception occurred: " + e.getClass().getSimpleName());
//
//}
        clickOnElement(newOrderScreen.newOrderModule);
        waitForVisibility(topDropDown);
        clickOnElement(topDropDown,"Click on Top Dropdown");
        waitForVisibility(menuManagement);
        clickOnElement(menuManagement,"click on menu management");
    }

    //---> Menu

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Menu Name']")
    private WebElement menuNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Menu Name']")
    private WebElement existingMenuErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Menu Name cannot be empty')]")
    private WebElement emptyMenuErrMsg;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Menu Name']")
    private WebElement invalidMenuErrMsg;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Menu'])[2])/android.view.View[2]")
    private WebElement searchBarIconMenu;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Menu One')]")
    private WebElement menuFirstField;


    public void addMenuDetails(String val){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidMenuDetails" -> {
                clickOnElement(menuNameField);
                typeTextIntoElement(menuNameField, "Menu One");
            }
            case "EmptyMenuName" -> clickOnElement(menuNameField);
            case "NumMenuName" -> {
                clickOnElement(menuNameField);
                typeTextIntoElement(menuNameField, "12345");
            }
        }
        clickOnElement(closeDialog);
    }

    public void getMenuErrorMsg(String val){
        if(val.equals("ValidMenuDetails")){
            clickOnElement(searchBarIconMenu);
            clickOnElement(searchBar);
            clearText(searchBar);
            typeTextIntoElement(searchBar,"Menu One");
            Assert.assertTrue(menuFirstField.isDisplayed());
        }
        else if (val.equalsIgnoreCase("EmptyMenuName")) {

        //    Assert.assertTrue(emptyMenuErrMsg.isDisplayed());
        } else if (val.equalsIgnoreCase("NumMenuName")) {

        }
    }


    public void searchMenu(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconMenu);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"Menu One");
    }

    public void validateSearchMenu(){
        Assert.assertTrue(menuFirstField.isDisplayed());
    }

    // ----> Categories

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Categories'])[1]")
    private WebElement categories;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Category Name']")
    private WebElement categoryName;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Category Name already exists')]")
    private WebElement existingCategoryErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Category Name cannot be empty')]")
    public WebElement emptyCategoryErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Category Name cannot be number')]")
    private  WebElement invalidDataTypeCategoryErrMsg;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Categories'])[2])/android.view.View[2]")
    private WebElement searchBarIconCategory;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BAKERY')]")
    private WebElement categoryFirstField;

    public void addCategoryDetails(String val){
        clickOnElement(categories);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidDetails" -> {
                clickOnElement(categoryName);
                typeTextIntoElement(categoryName, "AbcdCat");
            }
            case "ExistingCategoryName" -> {
                clickOnElement(categoryName);
                typeTextIntoElement(categoryName, "AbcdCat", "CategoryNam");
            }
            case "EmptyCategoryName" -> clickOnElement(categoryName);
            case "InvalidCategoryName" -> {
                clickOnElement(categoryName);
                typeTextIntoElement(categoryName, "1234", "CategoryName");
            }
        }
        clickOnElement(closeDialog);
    }
    public void getCategoryErrorMsg(String val){
        if(val.equals("ValidDetails")){
            Assert.assertTrue(categories.isDisplayed());
        }
        else if (val.equals("ExistingCategoryName")) {

          //  Assert.assertTrue(existingCategoryErrMsg.isDisplayed());
        }
        else if (val.equalsIgnoreCase("EmptyCategoryName")) {

            Assert.assertTrue(emptyCategoryErrMsg.isDisplayed());
        }
        else if (val.equalsIgnoreCase("InvalidCategoryName")) {

            Assert.assertTrue(invalidDataTypeCategoryErrMsg.isDisplayed());
        }
    }

    public void searchCategory(){

        clickOnElement(categories);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconCategory);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"BAKERY");
    }

    public void validateSearchCategory(){
      //  Assert.assertTrue(categoryFirstField.isDisplayed());
    }

    // --- > Modifiers

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Modifiers'])[1]")
    private WebElement modifiers;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Name']")
    private WebElement modifierNameField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Modifier Name cannot be empty')]")
    private WebElement emptyModifierNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Modifier Order Type cannot be empty')]")
    private WebElement emptyModifierOrderTypeErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Almond Cookie')]")
    private WebElement modifierFirstField;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Modifiers'])[2])/android.view.View[2]")
    private WebElement searchBarIconModifiers;


    public void addModifierDetails(String val){
        clickOnElement(modifiers);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidModifierDetails" -> {
                clickOnElement(modifierNameField);
                typeTextIntoElement(modifierNameField, "testModifier");
            }
            case "EmptyModifierName" -> clickOnElement(modifierNameField);
            case "EmptyModifierOrderType" -> {
                clickOnElement(modifierNameField);
                typeTextIntoElement(modifierNameField, "1234", "MenuName");
            }
        }
        clickOnElement(closeDialog);
    }
    public void getModifierErrorMsg(String val){
        if(val.equals("ValidModifierDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyModifierName")) {
            Assert.assertTrue(emptyModifierNameErrMsg.isDisplayed());
        }
        else if (val.equalsIgnoreCase("EmptyModifierOrderType")) {
            Assert.assertTrue(emptyModifierOrderTypeErrMsg.isDisplayed());

        }
    }

    public void searchModifier(){
        clickOnElement(modifiers);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconModifiers);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"Almond Cookie");
    }

    public void validateSearchModifier(){
      //  Assert.assertTrue(modifierFirstField.isDisplayed());
    }


    // ---> Addons

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Add-Ons'])[1]")
    private WebElement addOns;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Name']")
    private WebElement addOnsNameField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Addon Name cannot be empty')]")
    private WebElement emptyAddOnsNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Modifier Order Type cannot be empty')]")
    private WebElement emptyAddOnsOrderTypeErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Add Almond Milk')]")
    private WebElement addonFirstField;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Add-Ons'])[2])/android.view.View[2]")
    private WebElement searchBarIconAddons;


    public void addAddOnsDetails(String val){
        clickOnElement(addOns);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidAddonsDetails" -> {
                clickOnElement(addOnsNameField);
                typeTextIntoElement(addOnsNameField, "testAddOns");
            }
            case "EmptyAddonName" -> clickOnElement(addOnsNameField);
            case "EmptyAddonOrderType" -> {
                clickOnElement(addOnsNameField);
                typeTextIntoElement(addOnsNameField, "1234", "testAddOns");
            }
        }
        clickOnElement(closeDialog);
    }
    public void getAddonErrorMsg(String val){
        if(val.equals("ValidAddonsDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyAddonName")) {
            Assert.assertTrue(emptyAddOnsNameErrMsg.isDisplayed());
        }
        else if (val.equalsIgnoreCase("EmptyAddonOrderType")) {
            Assert.assertTrue(emptyAddOnsOrderTypeErrMsg.isDisplayed());
        }
    }

    public void searchAddOns(){
        clickOnElement(addOns);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconAddons);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"Add Almond Milk");
    }

    public void validateSearchAddOns(){
     //   Assert.assertTrue(addonFirstField.isDisplayed());
    }

    // ---> Products

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Products'])[1]")
    private WebElement products;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Product Name']")
    private WebElement productsNameField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Product Name should be set')]")
    private WebElement emptyProductNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Product Name already exists')]")
    private WebElement existingProductNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Absolut')]")
    private WebElement productsFirstField;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Products'])[2])/android.view.View[2]")
    private WebElement searchBarIconProducts;

    public void addProductDetails(String val){
        clickOnElement(products);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidProductsDetails" -> {
                clickOnElement(productsNameField);
                typeTextIntoElement(productsNameField, "testAddOns");
            }
            case "EmptyProductsName" -> clickOnElement(productsNameField);
            case "ExistingProductName" -> {
                clickOnElement(productsNameField);
                typeTextIntoElement(productsNameField, "1234", "testAddOns");
            }
        }
        clickOnElement(closeDialog);
    }
    public void getProductsErrorMsg(String val){
        if(val.equals("ValidProductsDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyProductsName")) {
            Assert.assertTrue(emptyProductNameErrMsg.isDisplayed());
        }
        else if (val.equalsIgnoreCase("ExistingProductName")) {
         //   Assert.assertTrue(existingProductNameErrMsg.isDisplayed());
        }
    }

    public void searchProducts(){
        clickOnElement(products);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconProducts);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"Absolut");
    }

    public void validateSearchProducts(){
    //    Assert.assertTrue(productsFirstField.isDisplayed());
    }

    // ---> Ingredients

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Ingredients'])[1]")
    private WebElement ingredients;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Name']")
    private WebElement ingredientNameField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Ingredient Name cannot be empty')]")
    private WebElement emptyIngredientNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'already exists')]")
    private WebElement existingIngredientNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Avocado')]")
    private WebElement ingredientFirstField;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Ingredients'])[2])/android.view.View[2]")
    private WebElement searchBarIconIngredient;

    public void addIngredientDetails(String val){
        clickOnElement(ingredients);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidIngredientsDetails" -> {
                clickOnElement(ingredientNameField);
                typeTextIntoElement(ingredientNameField, "testIngredient");
            }
            case "EmptyIngredientsName" -> clickOnElement(ingredientNameField);
            case "ExistingIngredientsName" -> {
                clickOnElement(ingredientNameField);
                typeTextIntoElement(ingredientNameField, "1234", "testIngredient");
            }
        }
        clickOnElement(closeDialog);
    }
    public void getIngredientErrorMsg(String val){
        if(val.equals("ValidIngredientsDetails")){

        } else if (val.equalsIgnoreCase("EmptyIngredientsName")) {
            Assert.assertTrue(emptyIngredientNameErrMsg.isDisplayed());
        } else if (val.equalsIgnoreCase("ExistingIngredientsName")) {
            Assert.assertTrue(existingIngredientNameErrMsg.isDisplayed());
        }
    }

    public void searchIngredients(){
        clickOnElement(ingredients);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconIngredient);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"Avocado");
    }

    public void validateSearchIngredient(){
    //    Assert.assertTrue(ingredientFirstField.isDisplayed());
    }

    // ---> Groups

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Groups'])[1]")
    private WebElement groups;
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Group Name']")
    private WebElement groupsNameField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Modifier Name cannot be empty')]")
    private WebElement emptyGroupsNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Modifier Group Name already exists')]")
    private WebElement existingGroupsNameErrMsg;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Bagels')]")
    private WebElement groupFirstField;
    @AndroidFindBy(xpath = "((//android.view.View[@content-desc='Groups'])[2])/android.view.View[2]")
    private WebElement searchBarIconGroup;

    public void addGroupsDetails(String val){
        clickOnElement(groups);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(ADD);

        switch (val) {
            case "ValidGroupsDetails" -> {
                clickOnElement(groupsNameField);
                typeTextIntoElement(groupsNameField, "testIngredient");
            }
            case "EmptyGroupsName" -> clickOnElement(groupsNameField);
            case "ExistingGroupsName" -> {
                clickOnElement(groupsNameField);
                typeTextIntoElement(groupsNameField, "1234", "testIngredient");
            }
        }
        clickOnElement(closeDialog);
    }
    public void getGroupsErrorMsg(String val){
        if(val.equals("ValidGroupsDetails")){

        }
        else if (val.equalsIgnoreCase("EmptyGroupsName")) {
            Assert.assertTrue(emptyGroupsNameErrMsg.isDisplayed());
        } else if (val.equalsIgnoreCase("ExistingGroupsName")) {
        //    Assert.assertTrue(existingGroupsNameErrMsg.isDisplayed());
        }
    }
    public void searchGroups(){
        clickOnElement(groups);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(searchBarIconGroup);
        clickOnElement(searchBar);
        clearText(searchBar);
        typeTextIntoElement(searchBar,"Bagels");
    }

    public void validateSearchGroups(){
      //  Assert.assertTrue(groupFirstField.isDisplayed());
    }
}
