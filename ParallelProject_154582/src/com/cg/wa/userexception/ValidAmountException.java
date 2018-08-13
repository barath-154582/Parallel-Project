package com.cg.wa.userexception;

public class ValidAmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ValidAmountException(){
		System.out.println("The amount should be positive");
	}
}
