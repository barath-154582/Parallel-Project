package com.cg.wa.service;

import com.cg.wa.beans.Account;
import com.cg.wa.userexception.*;

interface AccountServiceInterface {
	void createAccount(String mobileNo, String emailID, String password, String customerName, double accountBalance) throws AccountIDException;
	Account getAccountDetails(String mobileNo ) ;
	int deposit(String mobileNo, double amount) throws ValidAmountException ;
	int balance(String mobileNo) ;
	int withdraw(String mobileNo, double amount) throws WithdrawAmountException, ValidAmountException;
	int transfer(String mobileNo, String mobileNo2, double amount) throws WithdrawAmountException, VaildMobileNoException, AccountIDException, ValidAmountException, SameMobileNoException;

	void validateMobileNo(String mobileNo) throws VaildMobileNoException;
	void validateEmail(String email) throws ValidEmailIdException;
	void validateAccount(String mobileNo,String password) throws AccountIDException, VaildMobileNoException, PasswordException;
	void validateWithdraw(String mobileNo,double amount) throws WithdrawAmountException;
	void validatePassword(String password) throws PasswordException;
	public void validateAmount(double amount) throws ValidAmountException;
	public void validateCustomerName(String customerName) throws CustomerNameException;
}
