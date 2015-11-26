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
public class Test4 {

	/**
	 * How to mock private methods in JMockit
	 *
	 */
	@Test
    public void testPublicInvokesPrivateMockUp() {
        new MockUp<Simple>() {
            // Override the private method
            // Dont provide any ACCESSS MODIFIER!
            @Mock
            String privateMethod() {
                return "MockUp Invoke";
            }
        };
        Simple simple = new Simple();
        String str = simple.publicCallsPrivate();
        assertEquals("String returned - MockUp Invoke", "MockUp Invoke", str);
    }

}
