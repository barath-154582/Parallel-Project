package com.cg.wa.userexception;

public class ValidEmailIdException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidEmailIdException(){
		System.out.println("The email is in improper format, try again");
	}
}
