package com.qa.stepdef;

import com.qa.pages.PaymentsScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentsStepDef {



    @When("User is on Payments Screen")
    public void userIsOnPaymentsScreen(){
        new PaymentsScreen().onPayments();

    }

    //---> Taxes

    @When("User adds {string} Tax details")
    public void userAddsMenuDetails(String val){
        new PaymentsScreen().addTaxDetails(val);
    }
    @Then("User gets errorMsg for {string} Tax Details" )
    public void userGetsErrorMsgOnMenuDetails(String val){
        new PaymentsScreen().taxesErrMsg(val);
    }
    @When("User Search Tax on Search Bar")
    public void userSearchTaxOnSearchBar(){
        new PaymentsScreen().searchTax();
    }
    @Then("User Able to Search Item on Tax")
    public void userAbleToSearchItemOnTax(){
        new PaymentsScreen().validateSearchTax();
    }


    //---> Discounts

    @When("User adds {string} Discount details")
    public void userAddsDiscountDetails(String val){
        new PaymentsScreen().addDiscountDetails(val);
    }
    @Then("User gets errorMsg for {string} Discount Details" )
    public void userGetsErrorMsgOnDiscountDetails(String val){
        new PaymentsScreen().discountsErrMsg(val);
    }
    @When("User Search Discount on Search Bar")
    public void userSearchDiscountOnSearchBar(){
        new PaymentsScreen().searchDiscount();
    }
    @Then("User Able to Search Item on Discount")
    public void userAbleToSearchItemOnDiscount(){
        new PaymentsScreen().validateSearchDiscount();
    }


    //---> Service Charge

    @When("User adds {string} Service Charge details")
    public void userAddsServiceChargeDetails(String val){
        new PaymentsScreen().addServiceChargeDetails(val);
    }
    @Then("User gets errorMsg for {string} Service Charge Details" )
    public void userGetsErrorMsgOnServiceChargeDetails(String val){
        new PaymentsScreen().serviceChargeErrMsg(val);
    }
    @When("User Search Service Charge on Search Bar")
    public void userSearchServiceChargeOnSearchBar(){
        new PaymentsScreen().searchServiceCharge();
    }
    @Then("User Able to Search Item on Service Charge")
    public void userAbleToSearchItemOnServiceCharge(){
        new PaymentsScreen().validateSearchServiceCharge();
    }
}
