package com.app.api.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.aplicacion.ProductoAplicacion;
import com.app.api.domain.services.ProductoService;
import com.app.api.infrastucture.mapper.ProductoMapper;
import com.app.api.infrastucture.rest.ProductoRest;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	ProductoAplicacion productoAplicacion;

	public ProductoController(@Autowired ProductoService productoService, @Autowired ProductoMapper productoMapper) {
		this.productoAplicacion = new ProductoAplicacion(productoService, productoMapper);
	}

	@GetMapping
	List<ProductoRest> getProductos() {
		return productoAplicacion.listar();
	}

	@GetMapping("/report/general")
	public String exportGeneralReport() throws FileNotFoundException, JRException {
		return productoAplicacion.exportGeneralReport();
	}
	
	@PostMapping("/report/id_list")
	public String exportListReport(@RequestBody List<String> codigos) throws FileNotFoundException, JRException {
		return productoAplicacion.exportListReport(codigos);
	}
	
	
	@PostMapping
	public void addProducto(@RequestBody ProductoRest producto) {
		productoAplicacion.crear(producto);
	}

}
