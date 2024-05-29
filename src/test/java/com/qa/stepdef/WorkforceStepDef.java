package com.qa.stepdef;

import com.qa.pages.WorkforceScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkforceStepDef {

    @When("User is on Workforce Screen")
    public void userIsOnWorkforceScreen(){
        new WorkforceScreen().onWorkforce();
    }

    @When("User adds {string} Employee details")
    public void userAddsEmployeeDetails(String val){
        new WorkforceScreen().addEmployeeDetails(val);
    }
    @Then("User gets errorMsg for {string} Employee Details" )
    public void userGetsErrorMsgOnEmployeeDetails(String val){
        new WorkforceScreen().taxesErrMsg(val);
    }
    @When("User Search Employee on Search Bar")
    public void userSearchEmployeeOnSearchBar(){
    }
    @Then("User Able to Search Item on Employee")
    public void userAbleToSearchEmployee(){
    }
}
