package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchBoxButton;

    @FindBy(xpath = "//span[contains(text(),'Apple')][1]")
    private WebElement productNameApple;

    @FindBy(xpath = "//span[contains(text(),'Apple')]/following::span[1]")
    private WebElement productNameIphone;


    public void typeProductName(String productName){
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton(){
        searchBoxButton.click();
    }

    public String appleProdcutName(){
        return productNameApple.getText().substring(0,12);
    }

    public String productNameIphone(){
        return productNameIphone.getText().substring(0,5);
    }
}
