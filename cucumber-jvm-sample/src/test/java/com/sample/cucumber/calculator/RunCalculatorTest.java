package com.sample.cucumber.calculator;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "com.sample.cucumber.calculator.steps",
        features = "classpath:cucumber/calculator.feature"
)
public class RunCalculatorTest {
}
