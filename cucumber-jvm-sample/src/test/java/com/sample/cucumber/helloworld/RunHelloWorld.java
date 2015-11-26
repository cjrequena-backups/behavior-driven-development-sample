package com.sample.cucumber.helloworld;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "com.sample.cucumber.helloworld.steps",
        features = "classpath:cucumber/helloworld.feature"
)
public class RunHelloWorld {
}
