package com.context;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestContext {

    private WebDriver driver = null;

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void launchApplication() {
        getDriver().get("https://www.amazon.com/");
    }

    public void quit(){
        getDriver().quit();
    }
}
