package com.sample.jmockit;

public class Simple {
	private String privateMethod() {
        return "Private Method";
    }
    public String publicCallsPrivate() {
        return privateMethod();
    }
}
