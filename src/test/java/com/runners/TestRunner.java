package com.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        monochrome = true,
        publish = true
)
public class TestRunner {
}