package com.project.spotify.exceptions;

public class EmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException(String email) {
		super(String.format("L'email " + email + " est déjà utilisé"));
	}
}
