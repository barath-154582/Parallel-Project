package com.cg.wa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.wa.service.AccountService;
import com.cg.wa.userexception.AccountIDException;
import com.cg.wa.userexception.CustomerNameException;
import com.cg.wa.userexception.PasswordException;
import com.cg.wa.userexception.SameMobileNoException;
import com.cg.wa.userexception.VaildMobileNoException;
import com.cg.wa.userexception.ValidAmountException;
import com.cg.wa.userexception.ValidEmailIdException;
import com.cg.wa.userexception.WithdrawAmountException;

public class Tests {
	AccountService s=new AccountService();
	
	@Test
	public void testName() {
		//name should contain firstname and lastname
		boolean t=false;
		try {
			System.out.println("TestName");
			s.validateCustomerName("Abcdasd");
		} catch (CustomerNameException e) {
			t=true;
		}
		assertTrue(t);
	}
	
	@Test
	public void testName2() {
		//name should contain firstname and lastname
		boolean t=false;
		try {
			System.out.println("TestName2");
			s.validateCustomerName("Abcd Efg");
			t=true;
		} catch (CustomerNameException e) {
			t=false;
		}
		assertTrue(t);
	}
	
	@Test
	public void testName3() {
		//First alphabet of the name should be in capital letter else exception is thrown
		boolean t=false;
		try {
			System.out.println("TestName3");
			s.validateCustomerName("sbcdasd asuie");
		} catch (CustomerNameException e) {
			t=true;
		}
		assertTrue(t);
	}
	
	@Test
	public void testEmail() {
		//Email should have name in small letters and @ mail name and . and extension
		boolean t=false;
		try {
			System.out.println("TestEmail");
			s.validateEmail("sbcdasd");
		} catch (ValidEmailIdException e) {
			t=true;
		}
		assertTrue(t);
	}
	
	@Test
	public void testEmail2() {
		//Email should have name in small letters and @ mail name and . and extension
		boolean t=false;
		try {
			System.out.println("TestEmail2");
			s.validateEmail("amazing@gmail.com");
			t=true;
		} catch (ValidEmailIdException e)  {
		}
		assertTrue(t);
	}
	
	@Test
	public void testEmail3() {
		//Email should have name in small letters and @ mail name and . and extension
		boolean t=false;
		try {
			System.out.println("TestEmail3");
			s.validateEmail("jhAsdfjh@gmail.com");
		} catch (ValidEmailIdException e) {
			t=true;
		}
		assertTrue(t);
	}
	
	@Test
	public void testMobileNo() {
		//mobile no should have 10 numbers 
		boolean t=false;
		try {
			s.validateMobileNo("12345");
		} catch (VaildMobileNoException e) {
			t=true;
		}
		assertTrue(t);
		
	}
	
	@Test
	public void testMobileNo1() {
		//mobile no should have 10 numbers 
		boolean t=false;
		try {
			s.validateMobileNo("1234asdss5");
		} catch (VaildMobileNoException e) {
			t=true;
		}
		assertTrue(t);
		
	}
	
	@Test
	public void testMobileNo2() {
		//mobile no should have 10 numbers 
		boolean t=false;
		try {
			s.validateMobileNo("1234567890");
			t=true;
		} catch (VaildMobileNoException e) {
		}
		assertTrue(t);
		
	}
	
	@Test
	public void testPassword() {
		//password should have at least one special character, a lowercase, an uppercase, and a number with 6 digits in length minimum 
		boolean t=false;
		try {
			s.validatePassword("Abcd234");
		} catch (PasswordException e) {
			t=true;
		}
		assertTrue(t);
	}
	
	@Test
	public void testPassword2() {
		//password should have at least one special character, a lowercase, an uppercase, and a number with 6 digits in length minimum 
		boolean t=false;
		try {
			s.validatePassword("andf@123");
		} catch (PasswordException e) {
			t=true;
		}
		assertTrue(t);
	}
	
	@Test
	public void testPassword3() {
		//password should have at least one special character, a lowercase, an uppercase, and a number with 6 digits in length minimum 
		boolean t=false;
		try {
			s.validatePassword("Abcd@123");
			t=true;
		} catch (PasswordException e) {
		}
		assertTrue(t);
	}
	
	@Test
	public void testAccount() {
		//mobileNo 1236547890 with password Acbd@123 is already created in DAO layer
		boolean t=true;
		try {
			s.validateAccount("1236547890", "Abcd@123");
			t=false;
		} catch (AccountIDException e) {
		} catch (VaildMobileNoException e) {
		} catch (PasswordException e) {
		}
		assertTrue(t);
	}
	
	@Test
	public void testAccount2() {
		//mobileNo 1236547890 with password Acbd@123 is already created in DAO layer
		boolean t=false;
		try {
			s.validateAccount("1236547890", "Acbd@123");
			t=true;
		} catch (AccountIDException e) {
		} catch (VaildMobileNoException e) {
		} catch (PasswordException e) {
		}
		assertTrue(t);
	}
	
	@Test
	public void testAccount3() {
		//mobileNo 1236547890 with password Acbd@123 is already created in DAO layer
		boolean t=true;
		try {
			s.validateAccount("1236547890", "Abcd");
			t=false;
		} catch (AccountIDException e) {
		} catch (VaildMobileNoException e) {
		} catch (PasswordException e) {
		}
		assertTrue(t);
	}
	
	@Test
	public void testAccount4() {
		//mobileNo 123890 doesn't exist
		boolean t=true;
		try {
			s.validateAccount("123890", "Adbc@123");
			t=false;
		} catch (AccountIDException e) {
		} catch (VaildMobileNoException e) {
		} catch (PasswordException e) {
		}
		assertTrue(t);
	}
	@Test 
	public void testAmount() {
		//Amount should be positive
		boolean t=false;
		try {
			s.validateAmount(60);
			t=true;
		} catch (ValidAmountException e) {
		}
		assertTrue(t);
	}
	
	@Test 
	public void testAmount2() {
		//Amount should be positive
		boolean t=true;
		try {
			s.validateAmount(0);
			t=false;
		} catch (ValidAmountException e) {
		}
		assertTrue(t);
	}

	@Test 
	public void testAmount3() {
		//Amount should be positive
		boolean t=true;
		try {
			s.validateAmount(-60);
			t=false;
		} catch (ValidAmountException e) {
		}
		assertTrue(t);
	}
	@Test 
	public void testDeposit() {
		//mobileNo 1236547890 has an initial balance of 260, depositing non-positive values throws exception
		double d=0;
		try {
			d=s.deposit("1236547890", 40);
		} catch (ValidAmountException e) {
		}
		assertEquals(300,(int)d);
	}
	@Test 
	public void testDeposit2() {
		//mobileNo 1236547890 has an initial balance of 260, depositing non-positive values throws exception
		double d=0;
		boolean t=true;
		try {
			d=s.deposit("1236547890", -40);
			t=false;
		} catch (ValidAmountException e) {
		}
		assertTrue(t);
	}
	@Test 
	public void testDeposit3() {
		//mobileNo 1236547890 has an initial balance of 260, depositing non-positive values throws exception
		double d=0;
		boolean t=true;
		try {
			d=s.deposit("1236547890", 0);
			t=false;
		} catch (ValidAmountException e) {
		}
		assertTrue(t);
	}
	@Test
	public void testWithdraw() {
		//mobileNo 1234562490 has an initial balance of 590 rupees
		double d=0;
		String mobileNo="1234562490";
		try {
			d=s.withdraw(mobileNo, 90);
		} catch (WithdrawAmountException | ValidAmountException e) {
		}
		assertEquals(500,(int)d);
	}
	@Test
	public void testWithdraw2() {
		//mobileNo 1623567890 has an initial balance of 480 rupees
		double d=0;
		boolean t=true;
		String mobileNo="1623567890";
		try {
			d=s.withdraw(mobileNo, -90);
			t=false;
		} catch (WithdrawAmountException | ValidAmountException e) {
		}
		assertTrue(t);
	}
	@Test
	public void testWithdraw3() {
		//mobileNo 1623567890 has an initial balance of 480 rupees
		double d=0;
		boolean t=true;
		String mobileNo="1623567890";
		try {
			d=s.withdraw(mobileNo, 10000);
			t=false;
		} catch (WithdrawAmountException | ValidAmountException e) {
		}
		assertTrue(t);
	}
	@Test
	public void testTransfer() {
		//mobileNo 1623567890 has an initial balance of 480 rupees
		//mobileNo2 12345 doesn't exist
		double d=0;
		boolean t=true;
		String mobileNo="1623567890";
		try {
			d=s.transfer(mobileNo, "12345",30 );
			t=false;
		} catch (WithdrawAmountException | VaildMobileNoException | AccountIDException | ValidAmountException
				| SameMobileNoException e) {
			
		}
		assertTrue(t);
	}
	@Test
	public void testTransfer2() {
		//mobileNo 1623567890 has an initial balance of 480 rupees
		//mobileNo2 1623567890 is same as that of the mobileNo, so exception is thrown
		double d=0;
		boolean t=true;
		String mobileNo="1623567890";
		try {
			d=s.transfer(mobileNo, mobileNo,30 );
			t=false;
		} catch (WithdrawAmountException | VaildMobileNoException | AccountIDException | ValidAmountException
				| SameMobileNoException e) {
		}
		assertTrue(t);
	}
	@Test
	public void testTransfer3() {
		//mobileNo 1623567890 has an initial balance of 480 rupees
		//amount is negative, so exception is thrown
		double d=0;
		boolean t=true;
		String mobileNo="1623567890";
		try {
			d=s.transfer(mobileNo, "1234562490",-30 );
			t=false;
		} catch (WithdrawAmountException | VaildMobileNoException | AccountIDException | ValidAmountException
				| SameMobileNoException e) {
		}
		assertTrue(t);
	}
	
	@Test
	public void testTransfer4() {
		//mobileNo 1623567890 has an initial balance of 480 rupees
		//no exception
		double d=0;
		boolean t=true;
		String mobileNo="1623567890";
		try {
			d=s.transfer(mobileNo, "1456567890",30 );
			t=false;
		} catch (WithdrawAmountException | VaildMobileNoException | AccountIDException | ValidAmountException
				| SameMobileNoException e) {
		}
		assertEquals(450,(int)d);
	}
}
