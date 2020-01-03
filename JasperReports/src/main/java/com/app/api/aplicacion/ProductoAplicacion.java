package com.app.api.aplicacion;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.app.api.domain.services.ProductoService;
import com.app.api.infrastucture.mapper.ProductoMapper;
import com.app.api.infrastucture.rest.ProductoRest;

import net.sf.jasperreports.engine.JRException;

public class ProductoAplicacion {

	ProductoService productoService;

	ProductoMapper productoMapper;

	public ProductoAplicacion(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public void crear(ProductoRest p) {
		if (p.getId() == null) {
			p.setId(UUID.randomUUID().toString());
		}
		productoService.guardar(productoMapper.apitransformarDtoParaDominio(p));
	}

	public List<ProductoRest> listar() {
		return productoMapper.apitransformarListDominioParaDto(productoService.buscarTodos());
	}

	public ProductoRest buscar(String codigo) {
		return productoMapper.apitransformarDominioParaDto(productoService.buscarPorId(codigo));
	}

	public void eliminar(String codigo) {
		productoService.eliminarPorId(codigo);
	}

	public void actualizar(ProductoRest p) {
		productoService.editar(productoMapper.apitransformarDtoParaDominio(p));
	}

	public String exportGeneralReport() throws FileNotFoundException, JRException {
		return productoService.exportGeneralReport();
	}

	public String exportListReport(List<String> codigos) throws FileNotFoundException, JRException {
		return productoService.exportListReport(codigos);
	}
	
}
