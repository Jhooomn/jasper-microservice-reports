package com.app.api.exceptions;

public class NombreMayusculaException extends RuntimeException {

	public NombreMayusculaException() {
		super("Debe ser nombre en mayuscula");
	}

}
