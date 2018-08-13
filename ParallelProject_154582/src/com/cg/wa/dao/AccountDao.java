package com.cg.wa.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.wa.beans.Account;

public class AccountDao implements AccountDaoInterface {
	Map<String,Account> accountEntry=new HashMap<>();
	public AccountDao() {
		accountEntry=new HashMap<String,Account>();
		Account a=new Account( "guadalupe@gmail.com", "Abcd@123","Guadalupe Schuldt" , 300);
		accountEntry.put("1234567890", a);
		a=new Account( "standish@gmail.com", "Acbd@123","Ernestine Standish" , 260);
		accountEntry.put("1236547890", a);
		a=new Account( "kinslow@gmail.com", "Adbc@123","Crystle Kinslow" , 790);
		accountEntry.put("1254567890", a);
		a=new Account( "vivienne@gmail.com", "Adcb@123","Vivienne Blick" , 360);
		accountEntry.put("1456567890", a);
		a=new Account( "rexford@gmail.com", "Acdb@123","Glenn Rexford" , 480);
		accountEntry.put("1623567890", a);
		a=new Account( "danica@gmail.com", "Abdc@123","Danica Friend" , 590);
		accountEntry.put("1234562490", a);
	}
	@Override
	public Account getAccountDetails(String mobileNo) {
		return accountEntry.get(mobileNo);
	}

	@Override
	public int deposit(String mobileNo, double deposit) {
		accountEntry.get(mobileNo).setAccountBalance(deposit,1);
		return (int) accountEntry.get(mobileNo).getAccountBalance();
	}

	@Override
	public int balance(String mobileNo) {
		Account a=accountEntry.get(mobileNo);
		
		return (int) a.getAccountBalance();
		
	}

	@Override
	public int withdraw(String mobileNo, double withdraw) {
		accountEntry.get(mobileNo).setAccountBalance(withdraw,-1);
		return (int) accountEntry.get(mobileNo).getAccountBalance();
	}
	
	@Override
	public Map<String, Account> gepMap() {
		return accountEntry;
	}
	@Override
	public void createAccount(String mobileNo,String emailID, String password, String customerName, double accountBalance) {
		Account a=new Account(emailID,password,customerName,accountBalance);
		accountEntry.put(mobileNo, a);
		
	}
	public void printTransactions(String mobileNo) {
		if(accountEntry.get(mobileNo).getArray().size()==0) {
			System.out.println("No Transactions Recorded");
			return;
		}
		for(String s: accountEntry.get(mobileNo).getArray()) {
			System.out.println(s);
		}
	}
	

	

	
}
