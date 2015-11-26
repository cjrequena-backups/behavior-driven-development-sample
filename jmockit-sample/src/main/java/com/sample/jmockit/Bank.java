package com.sample.jmockit;

public class Bank {

	DBManager dbManager = new DBManager();

	static int balanceAmount;

	// Static block begins
	static {
		updateBalance(100);
	}

	public static void updateBalance(float balance) {
		balanceAmount += balance;
	}

	public String processAccount(int accountID) {
		// Some other code goes here
		String accountHolderName = dbManager.retrieveAccountHolderName(accountID);
		// some more processing code
		return accountHolderName;
	}

	public String makeConnection() {
        // some connection related code
        // goes here
        // call to static method
        String conStr = DBManager.getConnectionString();
        // If the connection String
        // is anything other than
        // ORIGINAL return FAIL
        if (conStr.equals("ORIGINAL")) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
    }
}
