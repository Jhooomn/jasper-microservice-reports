package com.app.api.domain.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Producto;

// Productos de dominio 
@Component
public interface ProductoService {
	public List<Producto> buscarPorIds(List<String> codigos);

	public List<Producto> buscarTodos();

	public void guardar(Producto producto);

	public Producto buscarPorId(String id);

	public void eliminarPorId(String id);

	public void editar(Producto producto);
}
