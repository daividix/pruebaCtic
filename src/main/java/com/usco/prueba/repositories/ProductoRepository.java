package com.usco.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usco.prueba.models.Producto;

@Repository("prodcuto_repository")
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
