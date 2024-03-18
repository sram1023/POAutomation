package com.stepdefinitions;

import com.context.TestContext;
import com.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class MyStepdefs {

    private final TestContext testContext = new TestContext();
    private final HomePage homePage = new HomePage(testContext.getDriver());

    @Given("the user land on the site")
    public void applicationSite() {
        testContext.launchApplication();
    }

    @And("enter the product name {string} in the search bar")
    public void enterTheProductNameInTheSearchBar(String productName) {
        homePage.typeProductName(productName);
    }

    @And("click on the search button")
    public void clickOnTheSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("verify that the first result contains the text {string}")
    public void verifyThatTheFirstResultContainsTheText(String searchProductName) {
        System.out.println("Expected:" + searchProductName + "  Actual:" + homePage.appleProdcutName() + " " + homePage.productNameIphone());
        Assert.assertTrue(searchProductName.contains(homePage.appleProdcutName() + " " + homePage.productNameIphone()));
        testContext.quit();
    }
}
