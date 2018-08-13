package com.cg.wa.beans;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String emailID;
	private String customerName;
	private double accountBalance;
	private String password;
	private String accountID;
	private List<String> l=new ArrayList<>();
	private static int n=0;
	public Account(String emailID, String password, String customerName, double accountBalance) {
		super();
		accountID="AC"+n;
		n++;
		this.password = password;
		this.emailID=emailID;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}
	public String getAccountID() {
		return accountID;
	}

	public String getEmailId() {
		return this.emailID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double amount,int operation) {
		if(operation<0) {
			this.accountBalance = this.accountBalance-amount;
		}
		else {
			this.accountBalance=this.accountBalance+amount;
		}
	}
	public String getPassword() {
		return this.password;
	}
	public void resetPassword(String password) {
		this.password=password;
	}
	public List<String> getArray() {
		return l;
	}
	public void displayAccount() {
		System.out.println(this.customerName +"  "+this.accountID);
		System.out.println("Balance "+this.accountBalance);
		System.out.println("Email "+this.emailID);
	}
	
}
