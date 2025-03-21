package com.mx.Tienda.Service;

import java.util.List;

import com.mx.Tienda.Entity.Tienda;

public interface ITiendaService {
	public void guardar(Tienda tienda);

	public void editar(Tienda tienda);

	public Tienda buscar(Integer idTienda);

	public void eliminar(Integer idTienda);

	public List<Tienda> listar();

}
