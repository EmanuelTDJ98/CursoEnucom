package com.mx.MS.Proveedores.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mx.MS.Proveedores.Entity.Proveedores;

@Repository
public interface IProveedoresDao extends JpaRepository<Proveedores, Long>{
	
	public List<Proveedores> findByTiendaId(int tiendaId);
}
