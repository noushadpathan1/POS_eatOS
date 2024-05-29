package com.qa.stepdef;

import com.qa.pages.NewOrderScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewOrderStepDef {

    @When("User Select Product and Place order")
    public void userSelectProductandPlaceOrder(){
        new NewOrderScreen().productsField();
    }
    @Then("Verify the Ticket Status")
    public void verifytheTicketStatus(){
        new NewOrderScreen().verifyTicketStatus();
    }
}
