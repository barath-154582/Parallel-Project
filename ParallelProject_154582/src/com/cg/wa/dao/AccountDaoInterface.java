package com.cg.wa.dao;

import java.util.Map;

import com.cg.wa.beans.Account;

interface AccountDaoInterface {
	
	Account getAccountDetails(String mobileNo);
	void createAccount(String mobileNo,String emailID, String password, String customerName, double accountBalance);
	int deposit(String mobileNo, double amount);
	int balance(String mobileNo);
	int withdraw(String mobileNo, double amount);
//	void transfer(String mobileNo, String mobileNo2, double amount);
	
	Map<String,Account> gepMap();
}
