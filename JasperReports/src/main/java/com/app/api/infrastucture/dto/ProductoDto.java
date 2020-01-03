package com.app.api.infrastucture.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductoDto extends BaseEntity {

	private String nombre;
	private Double valor;

	public ProductoDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductoDto(String nombre, Double valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
