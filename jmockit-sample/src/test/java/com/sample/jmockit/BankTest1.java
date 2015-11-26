package com.sample.jmockit;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTest1 {

	/*
	 * In the following example the static initialization block calls a static method and sets the bankBalance to 100. But in our test case we want to start off
	 * with 500.
	 *
	 * Note the $clinit method in the BankTest class that calls the same method with 500 as the argument.
	 */
	@Test
	public void test1BankStaticBlock() {
		new MockUp<Bank>() {
			@Mock
			public void $clinit() {
				Bank.updateBalance(500);
			}
		};
		assertEquals("The balance amount is 500", 500, Bank.balanceAmount);
	}

}
