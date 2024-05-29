package com.qa.stepdef;

import com.qa.pages.MenuManagementScreen;
import com.qa.pages.RestaurantScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RestaurantStepDef {

    @Given("User is on Restaurant  Screen")
    public void userIsOnRestaurantScreen(){
        new RestaurantScreen().onRestaurant();
    }

    // Guestbook

    @When("User adds {string} Guestbook details")
    public void userAdds_condition_GuestbookDetails(String val){
        new RestaurantScreen().addGuestBookDetails(val);
    }
    @Then("User gets errorMsg for {string} Guestbook")
    public void userGetsErrorMsg_condition_Guestbook(String val){
        new RestaurantScreen().getGuestBookErrorMsg(val);
    }
    @When("User Search GuestBook on Search Bar")
    public void userSearchGuestBookOnSearchBar(){
        new RestaurantScreen().searchGuestBook();
    }
    @Then("User Able to Search Item on GuestBook")
    public void userAbleToSearchItemOnGuestbook(){
        new RestaurantScreen().validateSearchGuestBook();
    }

    //Schedule Info

    @When("User adds {string} Schedule Info details")
    public void userAdds_condition_ScheduleInfoDetails(String val){
        new RestaurantScreen().addScheduleInfoDetails(val);
    }
    @Then("User gets errorMsg for {string} Schedule Info")
    public void userGetsErrorMsg_condition_ScheduleInfo(String val){
        new RestaurantScreen().getScheduleInfoErrorMsg(val);
    }
    @When("User Search Schedule Info on Search Bar")
    public void userSearchScheduleInfoOnSearchBar(){
        new RestaurantScreen().searchScheduleInfo();
    }
    @Then("User Able to Search Item on Schedule Info")
    public void userAbleToSearchItemOnScheduleInfo(){
        new RestaurantScreen().validateSearchScheduleInfo();
    }

    //Location Settings

    @When("User Tap on Buttons")
    public void userTapOnButtons(){

    }
    //Timed Pricing

    @When("User adds {string} Timed Pricing details")
    public void userAdds_condition_TimedPricingDetails(String val){
        new RestaurantScreen().addTimedPricingDetails(val);
    }
    @Then("User gets errorMsg for {string} Timed Pricing")
    public void userGetsErrorMsg_condition_TimedPricing(String val){
        new RestaurantScreen().getTimedPricingErrorMsg(val);
    }
    @When("User Search Timed Pricing on Search Bar")
    public void userSearchTimedPricingOnSearchBar(){
        new RestaurantScreen().searchTimedPricing();
    }
    @Then("User Able to Search Item on Timed Pricing")
    public void userAbleToSearchItemOnTimedPricing(){
        new RestaurantScreen().validateSearchTimedPricing();
    }




}
