package com.mx.MS.Productos.Service;

import java.util.List;

import com.mx.MS.Productos.Entity.Productos;

public interface IProductosService {
	public Productos guardar(Productos producto);

	public Productos editar(Productos producto);

	public Productos buscar(Long idProducto);

	public Productos eliminar(Long idProducto);

	public List<Productos> listar();

}
