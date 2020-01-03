package com.app.api.infrastucture.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Producto;
import com.app.api.infrastucture.dto.ProductoDto;
import com.app.api.infrastucture.rest.ProductoRest;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Nombre;
import com.app.api.shared.domain.Valor;
import com.app.api.shared.infrastucture.mapper.MapperApi;
import com.app.api.shared.infrastucture.mapper.MapperRepository;

@Component
public class ProductoMapper implements MapperRepository<ProductoDto, Producto>, MapperApi<ProductoRest, Producto> {

	@Override
	public ProductoRest apitransformarDominioParaDto(Producto o) {
		// TODO Auto-generated method stub
		ProductoRest producto = new ProductoRest();

		producto.setId(o.getId().getValue());
		producto.setNombre(o.getNombre().getValue());
		producto.setValor(o.getValor().getValue());

		return producto;
	}

	@Override
	public Producto apitransformarDtoParaDominio(ProductoRest i) {
		// TODO Auto-generated method stub

		return Producto.of(new Id(i.getId()), new Nombre(i.getNombre()), new Valor(i.getValor()));
	}

	@Override
	public ProductoDto transformarDominioParaDto(Producto o) {

		ProductoDto producto = new ProductoDto();

		producto.setId(o.getId().getValue());
		producto.setNombre(o.getNombre().getValue());
		producto.setValor(o.getValor().getValue());

		return producto;
	}

	@Override
	public Producto transformarDtoParaDominio(ProductoDto i) {
		// TODO Auto-generated method stub
		return Producto.of(new Id(i.getId()), new Nombre(i.getNombre()), new Valor(i.getValor()));

	}

}
