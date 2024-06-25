package com.qa.stepdef;


import com.qa.pages.MenuManagementScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MenuManagementStepDef {

    @When("User adds new Category details")
    public void userAddsNewCategoryDetails(){

    }

    @When("User Enter (.*) in field")
    public void userEnterField(String val){
        new MenuManagementScreen().emptyCategoryDetails();
    }
    @Then("User get (.*) on Screen")
    public void userGetErrMsgonScreen(String val){
        //Assert.assertTrue(new MenuManagementScreen().categoryErrMsg.isDisplayed());
    }
    @Then("User created Category successfully")
    public void userCreatedCategorySuccessfully(){

    }
    @Given("User is on Menu management Screen")
    public void UserIsOnMenuManagementScreen() {
        new MenuManagementScreen().onMenuManagement();
    }


    //Menu

    @When("User adds {string} Menu details")
    public void userAddsMenuDetails(String val){
        new MenuManagementScreen().addMenuDetails(val);
    }
    @Then("User gets errorMsg for {string} Menu Details" )
    public void userGetsErrorMsgOnMenuDetails(String val){
        new MenuManagementScreen().getMenuErrorMsg(val);
    }
    @When("User Search menu on Search Bar")
    public void userSearchMenuOnSearchBar(){
        new MenuManagementScreen().searchMenu();
    }
    @Then("User Able to Search Item on Menu")
    public void uUserAbleToSearchItemOnMenu(){
        new MenuManagementScreen().validateSearchMenu();
    }

    //Category

    @When("User adds {string} Category details")
    public void userAdds_condition_CategoryDetail(String val){
        new MenuManagementScreen().addCategoryDetails(val);
    }
    @Then("User gets errorMsg for {string} Category")
    public void userGetsErrorMsgOnCategory(String val){
        new MenuManagementScreen().getCategoryErrorMsg(val);
    }
    @When("User Search Category on Search Bar")
    public void userSearchCategoryOnSearchBar(){
        new MenuManagementScreen().searchCategory();
    }
    @Then("User Able to Search Item on Category")
    public void uUserAbleToSearchItemOnCategory(){
        new MenuManagementScreen().validateSearchCategory();
    }

    //Modifiers

    @When("User adds {string} Modifiers details")
    public void userAddsModifierDetails(String val){
        new MenuManagementScreen().addModifierDetails(val);
    }
    @Then("User gets errorMsg for {string} Modifiers" )
    public void userGetsErrorMsgOnModifierDetails(String val){
        new MenuManagementScreen().getModifierErrorMsg(val);
    }

    @When("User Search Modifier on Search Bar")
    public void userSearchModifierOnSearchBar(){
        new MenuManagementScreen().searchModifier();
    }
    @Then("User Able to Search Item on Modifier")
    public void uUserAbleToSearchItemOnModifier(){
        new MenuManagementScreen().validateSearchModifier();
    }
    //AddOns

    @When("User adds {string} Addons details")
    public void userAddsAddonDetails(String val){
        new MenuManagementScreen().addAddOnsDetails(val);
    }
    @Then("User gets errorMsg for {string} Addons" )
    public void userGetsErrorMsgOnAddon(String val){
        new MenuManagementScreen().getAddonErrorMsg(val);
    }
    @When("User Search Addons on Search Bar")
    public void userSearchAddonsOnSearchBar(){
        new MenuManagementScreen().searchAddOns();
    }
    @Then("User Able to Search Item on Addons")
    public void uUserAbleToSearchItemOnAddons(){
        new MenuManagementScreen().validateSearchAddOns();
    }

    //Products

    @When("User adds {string} Products details")
    public void userAddsProductsDetails(String val){
        new MenuManagementScreen().addProductDetails(val);
    }
    @Then("User gets errorMsg for {string} Products" )
    public void userGetsErrorMsgOnProducts(String val){
        new MenuManagementScreen().getProductsErrorMsg(val);
    }
    @When("User Search Products on Search Bar")
    public void userSearchProductsOnSearchBar(){
        new MenuManagementScreen().searchProducts();
    }
    @Then("User Able to Search Item on Products")
    public void uUserAbleToSearchItemOnProducts(){
        new MenuManagementScreen().validateSearchProducts();
    }

    //Ingredients

    @When("User adds {string} Ingredients details")
    public void userAddsIngredientsDetails(String val){
        new MenuManagementScreen().addIngredientDetails(val);
    }
    @Then("User gets errorMsg for {string} Ingredients" )
    public void userGetsErrorMsgOnIngredients(String val){
        new MenuManagementScreen().getIngredientErrorMsg(val);
    }
    @When("User Search Ingredients on Search Bar")
    public void userSearchIngredientsOnSearchBar(){
        new MenuManagementScreen().searchIngredients();
    }
    @Then("User Able to Search Item on Ingredients")
    public void uUserAbleToSearchItemOnIngredients(){
        new MenuManagementScreen().validateSearchIngredient();
    }

    //Groups

    @When("User adds {string} Groups details")
    public void userAddsGroupsDetails(String val){
        new MenuManagementScreen().addGroupsDetails(val);
    }
    @Then("User gets errorMsg for {string} Groups" )
    public void userGetsErrorMsgOnGroups(String val) {
        new MenuManagementScreen().getGroupsErrorMsg(val);
    }
    @When("User Search Groups on Search Bar")
    public void userSearchGroupsOnSearchBar(){
        new MenuManagementScreen().searchGroups();
    }
    @Then("User Able to Search Item on Groups")
    public void uUserAbleToSearchItemOnGroups(){
        new MenuManagementScreen().validateSearchGroups();
    }
}
