package com.cg.wa.userexception;

public class SameMobileNoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SameMobileNoException(){
		System.out.println("The account to be transferred should be different");
	}
}
