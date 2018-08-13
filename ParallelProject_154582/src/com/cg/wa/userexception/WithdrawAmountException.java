package com.cg.wa.userexception;

public class WithdrawAmountException extends Exception {
	/**
		 * 
		 */
		private static final long serialVersionUID = 2021381014628319249L;
		private String s="Account balance should be more than the withdrawal amount";

		public WithdrawAmountException() {
			System.out.println(s);
		}
		
	}
