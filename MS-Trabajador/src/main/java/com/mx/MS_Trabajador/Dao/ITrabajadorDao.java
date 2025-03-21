package com.mx.MS_Trabajador.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MS_Trabajador.Entity.Trabajador;
@Repository
public interface ITrabajadorDao extends JpaRepository<Trabajador, Long>{

}
