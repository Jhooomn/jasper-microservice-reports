package com.app.api.shared.infrastucture.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApi<I, O> {

	// Transformar
	public I apitransformarDominioParaDto(O o);

	public O apitransformarDtoParaDominio(I i);

	public default List<O> apitransformarListaDtoParaDominio(List<I> instancias) {
		return instancias.stream().map(o -> apitransformarDtoParaDominio(o)).collect(Collectors.toList());
	}

	public default List<I> apitransformarListDominioParaDto(List<O> instancias) {
		return instancias.stream().map(i -> apitransformarDominioParaDto(i)).collect(Collectors.toList());
	}
}
