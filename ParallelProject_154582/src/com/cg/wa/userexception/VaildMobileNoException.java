package com.cg.wa.userexception;

public class VaildMobileNoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s="The Mobile Number should have 10 digits, please try again";

	public VaildMobileNoException() {
	
		System.out.println(s);
	}
}
