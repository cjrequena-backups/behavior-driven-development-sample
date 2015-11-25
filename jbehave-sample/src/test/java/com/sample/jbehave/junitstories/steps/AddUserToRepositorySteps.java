package com.sample.jbehave.junitstories.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.sample.jbehave.shoppingcart.User;
import com.sample.jbehave.shoppingcart.UserDao;


public class AddUserToRepositorySteps{

	private UserDao	userDao;

	@Given("a user repository")
	public void aUserRepository() {
		userDao = new UserDao();
	}

	@When("the user adds $amount users to the user repository")
	public void userAddsUsersToRepository(final int amount) {
		for (int i = 0; i < amount; i++) {
			final User user = new User();
			user.setName("user " + i);
			userDao.save(user);
		}
	}

	@Then("the user repository must contain $amount users")
	public void productMustBeListed(final int amount) {
		Assert.assertEquals(amount, userDao.findAll().size());
	}



}
