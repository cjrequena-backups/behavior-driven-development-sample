package com.sample.jmockit;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTest4 {

	@Mocked
	DBManager dbManager;

	/**
	 * How to mock static methods in JMockit?
	 *
	 * The only thing to be done is to mark the field in the test class with @Mocked or create a local variable in the anonymous Expectations class.
	 */
	@Test
	public void testMakeConnection() {
		new NonStrictExpectations() {
			{
				DBManager.getConnectionString();
				returns("DUPLICATE");
			}
		};
		Bank bank = new Bank();
		String status = bank.makeConnection();
		assertEquals("Status is FAIL", "FAIL", status);
	}

}
