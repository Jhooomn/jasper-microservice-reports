package com.app.api.infrastucture.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRest {
	private String id;
	private String nombre;
	private Double valor;

}
