package com.cg.wa.service;

import com.cg.wa.dao.AccountDao;
import com.cg.wa.beans.Account;
import com.cg.wa.userexception.AccountIDException;
import com.cg.wa.userexception.CustomerNameException;
import com.cg.wa.userexception.PasswordException;
import com.cg.wa.userexception.SameMobileNoException;
import com.cg.wa.userexception.VaildMobileNoException;
import com.cg.wa.userexception.ValidAmountException;
import com.cg.wa.userexception.ValidEmailIdException;
import com.cg.wa.userexception.WithdrawAmountException;

public class AccountService implements AccountServiceInterface{
	public AccountDao a=new AccountDao();
	@Override
	public void createAccount(String mobileNo, String emailID, String password, String customerName,
			double amount) throws AccountIDException{
	
		if(a.gepMap().containsKey(mobileNo)) {
			throw new AccountIDException("The mobile number/account already exists, please try again");
		}
		a.createAccount(mobileNo, emailID, password, customerName, amount);
		
	}
	@Override
	public Account getAccountDetails(String mobileNo) {
		return a.getAccountDetails(mobileNo);
	}

	@Override
	public int deposit(String mobileNo, double amount) throws ValidAmountException  {
		validateAmount(amount);
		if(a.gepMap().get(mobileNo).getArray().size()>=5) {
			a.gepMap().get(mobileNo).getArray().remove(0);
		}
		int k=a.deposit(mobileNo, amount);
		a.gepMap().get(mobileNo).getArray().add("Deposited amount "+amount+", current Balance "+a.gepMap().get(mobileNo).getAccountBalance());
		
		return k;
	}

	@Override
	public int balance(String mobileNo){
		return a.balance(mobileNo);
	}

	@Override
	public int withdraw(String mobileNo, double amount) throws WithdrawAmountException, ValidAmountException {
		validateAmount(amount);
		validateWithdraw(mobileNo,amount);
		if(a.gepMap().get(mobileNo).getArray().size()>=5) {
			a.gepMap().get(mobileNo).getArray().remove(0);
		}
		int k=a.withdraw(mobileNo, amount);
		a.gepMap().get(mobileNo).getArray().add("Withdrawn amount "+amount+", current Balance "+a.gepMap().get(mobileNo).getAccountBalance());
		return k;
	}

	@Override
	public int transfer(String mobileNo, String mobileNo2, double amount) throws WithdrawAmountException, VaildMobileNoException, AccountIDException, ValidAmountException, SameMobileNoException {
		validateMobileNo(mobileNo2);
		validateWithdraw(mobileNo,amount);
		validateAmount(amount);
		if(!(a.gepMap().containsKey(mobileNo2))) {
			throw new AccountIDException("The account to be transferred does not exist, please try again");
		}
		if(mobileNo.equals(mobileNo2)) {
			throw new SameMobileNoException();
		}
		a.deposit(mobileNo2, amount);
		if(a.gepMap().get(mobileNo).getArray().size()>=5) {
			a.gepMap().get(mobileNo).getArray().remove(0);
		}
		int k=a.withdraw(mobileNo, amount);
		a.deposit(mobileNo2, amount);
		a.gepMap().get(mobileNo).getArray().add("Transferred amount "+amount+", current Balance "+a.gepMap().get(mobileNo).getAccountBalance());
		return k;
		
	}

	@Override
	public void validateMobileNo(String mobileNo) throws VaildMobileNoException {
		if(!(mobileNo.matches("[0-9]{10}"))) {
			throw new VaildMobileNoException();
		}
	}

	@Override
	public void validateEmail(String email) throws ValidEmailIdException {
		// TODO Auto-generated method stub
		if(!(email.matches("[a-z]{1}[a-z0-9]{3,20}[@]{1}[a-z]{4,8}[.]{1}[a-z.]{2,5}")||email.matches("[a-z]{1}[a-z]{3,20}[@]{1}[a-z]{4,8}[.]{1}[a-z.]{2,5}"))) {
			throw new ValidEmailIdException();
		}
	}

	@Override
	public void validateAccount(String mobileNo, String password) throws AccountIDException, VaildMobileNoException, PasswordException {
		// TODO Auto-generated method stub
		validateMobileNo(mobileNo);
		if(a.gepMap().containsKey(mobileNo)) {
			validatePassword(password);
			if(!a.gepMap().get(mobileNo).getPassword().equals(password)) {
				throw new AccountIDException("The password is incorrect, please try again");
			}
		}
		else {
			throw new AccountIDException("No such account exists, please try again");
		}
	}

	@Override
	public void validatePassword(String password) throws PasswordException {
		if(!(password.matches("(.*)[A-Z](.*)")&&password.matches("(.*)[a-z](.*)")&&password.matches("(.*)[0-9](.*)")&&password.matches("(.*)[!@#$%^&*()](.*)")&& password.length()>=6)){
			throw new PasswordException();
		}
		
	}

	@Override
	public void validateWithdraw(String mobileNo, double amount) throws WithdrawAmountException {
		if((a.gepMap().get(mobileNo).getAccountBalance()<=(amount))){
			throw new WithdrawAmountException();
		}
		
	}

	

	public void validateAmount(double amount) throws ValidAmountException{
		if(amount<=0) {
			throw new ValidAmountException();
		}
	}
	public void validateCustomerName(String customerName) throws CustomerNameException{
		
		if(!(customerName.length()>6 && customerName.matches("[A-Z]{1}[a-z]{2,16}[' ']{1}[A-Z]{1}[a-z]{2,16}"))) {
			throw new CustomerNameException();
		}
	}
	public void printTransactions(String mobileNo) {
		
		a.printTransactions(mobileNo);
	}
	
	
	

}
