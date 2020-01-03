package com.app.api.exceptions;

public class RegistroNoEncontradoException extends RuntimeException{
	public RegistroNoEncontradoException() {
		super("Registro no encontrado");
	}
}
