package com.app.api.infrastucture.repository.database;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.api.infrastucture.dto.ProductoDto;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, String> {

	@Query(value = "SELECT p FROM ProductoDto p WHERE p.id IN :codigos")
	List<ProductoDto> findProductosByIdList(@Param("codigos") Collection<String> codigos);
	
}
