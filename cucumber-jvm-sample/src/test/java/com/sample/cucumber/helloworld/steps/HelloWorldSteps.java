package com.sample.cucumber.helloworld.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorldSteps {

	boolean softwareSystem;
	boolean sayHello;

	@Given("^I am a software system$")
	public void i_am_a_software_system() throws Throwable {
		softwareSystem = true;
	}

	@When("^I want to say hello$")
	public void i_want_to_say_hello() throws Throwable {
		sayHello=true;
	}

	@Then("^the result should be 'Hello World'$")
	public void the_result_should_be_Hello_World() throws Throwable {
		if(softwareSystem && sayHello){
			System.out.println("Hello World");
		}
	}

}
