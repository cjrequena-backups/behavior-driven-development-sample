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
public class BankTest3 {

	/**
	 * How to mock public methods in JMockit?
	 *
	 * State Based Testing using the MockUp apis
	 *
	 * MockUp apis are categorized as State Based testing because the mocks you write are not dependent on the behaviour of the test class. They are defined
	 * independently and work the same in any case. In the code below observe how the MockUp class redefines the method retrieveAccountHolderName() of class
	 * DBManager. This is a great utility if only some methods of a class need to be redefined.
	 */

	@Test
	public void test3BankProcessAccount() {
		new MockUp<DBManager>() {
			@Mock
			public String retrieveAccountHolderName(int accountId) {
				return "Abhi";
			}
		};
		Bank bank = new Bank();
		String name = bank.processAccount(20);
		assertEquals("Account holder Name for A/C id 20 is 'Abhi' ", "Abhi", name);
	}

}
