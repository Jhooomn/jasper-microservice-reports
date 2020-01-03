package com.app.api.infrastucture.repository.adapter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Producto;
import com.app.api.domain.services.ProductoService;
import com.app.api.exceptions.RegistroNoEncontradoException;
import com.app.api.infrastucture.dto.ProductoDto;
import com.app.api.infrastucture.mapper.ProductoMapper;
import com.app.api.infrastucture.repository.database.ProductoRepository;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public List<Producto> buscarPorIds(List<String> codigos) {
		return productoRepository.findAllById(codigos.stream().map(codigo -> codigo).collect(Collectors.toList()))
				.stream().map(producto -> productoMapper.transformarDtoParaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(productoMapper.transformarDominioParaDto(producto));
	}

	@Override
	public void editar(Producto producto) {
		this.buscarPorId(producto.getId().getValue());
		productoRepository.save(productoMapper.transformarDominioParaDto(producto));
	}

	@Override
	public Producto buscarPorId(String id) {
		return productoMapper.transformarDtoParaDominio(
				productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoException()));
	}

	@Override
	public List<Producto> buscarTodos() {
		return productoRepository.findAll().stream().map(producto -> productoMapper.transformarDtoParaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void eliminarPorId(String id) {
		ProductoDto producto = productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoException());
		productoRepository.deleteById(producto.getId());
	}

}
