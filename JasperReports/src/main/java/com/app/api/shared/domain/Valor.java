package com.app.api.shared.domain;

import com.app.api.exceptions.PrecioException;

public class Valor {

	private final Double value;

	public Valor(Double valor) {
		try {
			this.value = valor;
			if (valor <= 0) {
				throw new PrecioException();
			}
		} catch (NullPointerException e) {
			throw new PrecioException();
		}
	}

	public Double getValue() {
		return value;
	}

}
