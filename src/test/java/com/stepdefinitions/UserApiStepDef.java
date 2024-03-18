package com.stepdefinitions;

import com.util.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class UserApiStepDef {

    private final Common common = new Common();

    @Given("create the user")
    public void createTheUser() {
        common.restActions("post");
    }

    @And("get the user detail")
    public void getTheUserDetail() {
        common.restActions("get");
    }

    @And("update the username")
    public void updateTheUserName() {
        common.restActions("update");
    }

    @And("delete the user")
    public void deleteTheUser() {
        common.restActions("delete");
    }
}
