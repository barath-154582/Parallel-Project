package com.cg.wa.userexception;

public class PasswordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordException(){
		System.out.println("Password should contatin \n	an Uppercase, \n	a Lowercase, \n	a Number, \n	and a special symbol \n	with a total length of minimum 6 characters");
	}
	
}
