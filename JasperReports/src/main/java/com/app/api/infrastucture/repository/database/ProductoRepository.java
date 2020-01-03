package com.app.api.infrastucture.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.infrastucture.dto.ProductoDto;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, String> {

}
