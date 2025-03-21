package com.mx.Tienda.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Tienda.Entity.Tienda;
 @Repository
public interface ITiendaRepository extends CrudRepository<Tienda, Integer>{

}
