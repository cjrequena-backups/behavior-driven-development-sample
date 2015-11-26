package com.sample.jmockit;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTest2 {

	@Mocked
	DBManager dbManager;

	/*
	 *
	 * How to mock public methods in JMockit?
	 *
	 * Behaviour Based Testing or using the Expectations class.
	 *
	 * In this technique we will be creating a Expectations anonymous inner class and define the expected behaviour when a method is invoked with particular
	 * arguments. This time the Bank class uses the DBManager to retrieve the Account Holder Name to process the account. The Bank's processAccount() method
	 * takes in an Account ID and passes it onto the DBManager's retrieveAccountHolder() method to get the name from the DB and returns the same. However we
	 * want to mask all the DB related code and return a name, say "Abhi" when retrieveAccountHolder() is invoked with the Account ID as 10.
	 *
	 */
	@Test
	public void test2RetrieveAccountHolderName() {

		Bank bank = new Bank();

		// Define the Expectations block here
		new Expectations() {
			{
				dbManager.retrieveAccountHolderName(10);
				returns("Abhi");
			}
		};
		String name = bank.processAccount(10);
		assertEquals("Account holder Name for A/C id 10 is 'Abhi' ", "Abhi", name);
	}

}
