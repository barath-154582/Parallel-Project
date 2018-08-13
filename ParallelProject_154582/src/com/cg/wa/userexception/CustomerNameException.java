package com.cg.wa.userexception;

public class CustomerNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerNameException() {
		System.out.println("Customer name should contain firstname and lastname only in alphabets");
	}
}
