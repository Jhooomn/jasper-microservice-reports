package com.app.api.domain.model;

import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Nombre;
import com.app.api.shared.domain.Valor;

public class Producto {

	private final Id id;

	private final Nombre nombre;

	private final Valor valor;

	public static Producto of(Id id, Nombre nombre, Valor valor) {
		return new Producto(id, nombre, valor);
	}

	public Producto(Id id, Nombre nombre, Valor valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}

	public Id getId() {
		return id;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public Valor getValor() {
		return valor;
	}

}
