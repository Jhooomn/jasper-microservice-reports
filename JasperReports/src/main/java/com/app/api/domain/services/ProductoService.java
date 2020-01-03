package com.app.api.domain.services;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Producto;

import net.sf.jasperreports.engine.JRException;

// Productos de dominio 
@Component
public interface ProductoService {
	public List<Producto> buscarPorIds(List<String> codigos);

	public List<Producto> buscarTodos();

	public void guardar(Producto producto);

	public Producto buscarPorId(String id);

	public void eliminarPorId(String id);

	public void editar(Producto producto);

	public String exportGeneralReport() throws FileNotFoundException, JRException;

	public String exportListReport(List<String> codigos) throws FileNotFoundException, JRException;

}
