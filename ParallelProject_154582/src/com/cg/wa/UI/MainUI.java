package com.cg.wa.UI;
import java.util.Scanner;

import com.cg.wa.service.AccountService;
import com.cg.wa.userexception.AccountIDException;
import com.cg.wa.userexception.CustomerNameException;
import com.cg.wa.userexception.PasswordException;
import com.cg.wa.userexception.SameMobileNoException;
import com.cg.wa.userexception.WithdrawAmountException;
import com.cg.wa.userexception.VaildMobileNoException;
import com.cg.wa.userexception.ValidAmountException;
import com.cg.wa.userexception.ValidEmailIdException;

public class MainUI {
	static Scanner in=new Scanner(System.in);
	static AccountService service=new AccountService();
	public static void main(String[] args) {
		int i=0;
		do {
			displaymenu();
			i=in.nextInt();
			switch(i) {
				case 1:
					String mobileNo;
					String password;
					String emailID;
					String customerName;
					double amount;
					System.out.println("To create a new Account, Enter the following details");
					while(true) {
						System.out.println("Enter MobileNo");
						mobileNo=in.next();
						try {
							service.validateMobileNo(mobileNo);
							break;
						} catch (VaildMobileNoException e) {
						}
					}
					while(true) {
						System.out.println("Enter Password");
						password=in.next();
						try {
							service.validatePassword(password);
							break;
						} catch (PasswordException e) {
						}
					}
					while(true) {
						System.out.println("Enter Email");
						emailID=in.next();
						try {
							service.validateEmail(emailID);
							break;
						} catch (ValidEmailIdException e) {
						}
					}
					while(true) {
						System.out.println("Enter Customer Name");
						in.nextLine();
						customerName=in.nextLine();
						try {
							service.validateCustomerName(customerName);
							break;
						} catch (CustomerNameException e) {
						}
					}
					while(true) {
						System.out.println("Enter initial balance");
						amount=in.nextDouble();
						try {
							service.validateAmount(amount);
							break;
						} catch (ValidAmountException e) {
						}
						
					}
				try {
					service.createAccount(mobileNo, emailID, password, customerName, amount);
					System.out.println("Account created Successfully");
				} catch (AccountIDException e) {
				}
				break;
				case 2:
					String mobileNo1;
					String pass;
					while(true) {
						System.out.println("Enter your mobile number and password");
						System.out.println("Mobile number :");
						mobileNo1=in.next();
						try {
							System.out.println("Password: ");
							pass=in.next();
							service.validateAccount(mobileNo1, pass);
							break;
						} catch (VaildMobileNoException e) {
						} catch (PasswordException e) {
						} catch (AccountIDException e) {
						}
					}
					System.out.println("Login Successful");
					do {
						displaymenu2();
						System.out.println("Enter your choice");
						int j=in.nextInt();
						if(j>=6||j<=0) break;
						switch(j) {
							case 1:
								System.out.println("The current Balance is "+service.balance(mobileNo1));
								System.out.println();
							break;
							case 2:
								
								while(true) {
									System.out.println("Enter the deposit amount");
									amount=in.nextInt();
									try {
										System.out.println("The current Balance is "+service.deposit(mobileNo1, amount));
										System.out.println();
										break;
									} catch (ValidAmountException e) {
									}
								}
							break;
							case 3:
								while(true) {
									System.out.println("Enter the withdrwaw amount");
									amount=in.nextInt();
									try {
										System.out.println("The current Balance is"+service.withdraw(mobileNo1, amount));
										System.out.println();
										break;
									} catch (WithdrawAmountException e) {
									} catch (ValidAmountException e) {
									}
								}
							break;
							case 4:
								while(true) {
									System.out.println("Enter the mobile number of the account you wish to transfer");
									String mobileNo2=in.next();
									try {
										service.validateMobileNo(mobileNo1);
										if(!service.a.gepMap().containsKey(mobileNo1)) {
											throw new AccountIDException("No such account Exists");
										}
										System.out.println("Enter the amount");
										amount=in.nextDouble();
										service.validateAmount(amount);
										System.out.println("The current Balance is "+service.transfer(mobileNo1, mobileNo2, amount));
										System.out.println();
										break;
									} catch (VaildMobileNoException e) {
									} catch (AccountIDException e) {
									} catch (ValidAmountException e) {
									} catch (WithdrawAmountException e) {
									} catch (SameMobileNoException e) {
									}
									
								}
							break;
							case 5: 
								service.printTransactions(mobileNo1);
								System.out.println();
							break;
						}
					}while(i<6 && i>0);
				default: break;
			}
		}while(i==1||i==2);
		System.out.println("Thank You");
	}
	public static void displaymenu() {
		System.out.println("Welcome to Wallet Application");
		System.out.println("If you are a New user, Enter 1 to create a new account");
		System.out.println("If you are an Existing User, Enter 2 to use our services");
		System.out.println("Enter 3 to exit the program");
	}
	public static void displaymenu2() {
		System.out.println("Display menu to Customer Care Representative to perform various operations");
		System.out.println("1) Account Balance Enquiry");
		System.out.println("2) Deposit into Account");
		System.out.println("3) Withdraw from Account");
		System.out.println("4) Transfer from Account1 to Account2");
		System.out.println("5) Print last 5 Transactions");
		System.out.println("6) Exit");
	}
	

}
