package com.project.spotify.exceptions;

public class NomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomException(String nom) {
		super(String.format("Le pseudo " + nom + " est déjà utilisé"));
	}
}
