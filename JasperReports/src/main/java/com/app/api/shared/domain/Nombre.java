package com.app.api.shared.domain;

import com.app.api.exceptions.NombreCaracterException;

public class Nombre {
	private final String value;

	public Nombre(String nombre) {
		try {
			this.value = nombre;
			if (!nombre.matches("[A-Z].*")) {
				throw new NombreCaracterException();

			}
		} catch (NullPointerException e) {
			throw new NombreCaracterException();
		}
	}

	public String getValue() {
		return value;
	}

}
