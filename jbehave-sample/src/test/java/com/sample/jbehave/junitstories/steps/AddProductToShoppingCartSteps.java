package com.sample.jbehave.junitstories.steps;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.sample.jbehave.shoppingcart.Product;
import com.sample.jbehave.shoppingcart.ShoppingCart;
import com.sample.jbehave.shoppingcart.User;

public class AddProductToShoppingCartSteps{
	private User user;
	private ShoppingCart shoppingCart;
	private Product product;

	@Given("a user")
	public void aUser() {
		user = new User();
	}

	@Given("a shopping cart")
	public void aShoppingCart() {
		shoppingCart = new ShoppingCart();
	}

	@Given("a product")
	public void aProduct() {
		product = new Product();
		product.setName("Coffee");
	}

	@When("the user adds the product to the shopping cart")
	public void userAddsProductToShoppingCart() {
		shoppingCart.add(user, product);
	}

	@Then("the product must be included in the list of the shoppingcart's entries")
	public void productMustBeListed() {
		List<Product> entries = shoppingCart.getProductsByUser(user);
		Assert.assertTrue(entries.contains(product));
	}
}
