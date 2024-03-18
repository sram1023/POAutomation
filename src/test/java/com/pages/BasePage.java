package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class BasePage {

    protected final WebDriver driver;
    private static WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (Objects.isNull(wait))
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitFor(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(WebElement parentElement, String childElement) {
        try {
            parentElement.findElement(By.xpath(childElement));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
