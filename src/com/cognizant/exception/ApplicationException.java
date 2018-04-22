package com.cognizant.exception;

public class ApplicationException extends Exception {
	/**
	 * The Generated Serial Version ID
	 */
	private static final long serialVersionUID = -1152779436008581185L;

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

	public ApplicationException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
