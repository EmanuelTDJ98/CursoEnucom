package com.mx.MS.Proveedores.Service;

import java.util.List;

import com.mx.MS.Proveedores.Entity.Proveedores;

public interface IProveedorService {
	public Proveedores guardar(Proveedores proveedor);

	public Proveedores buscar(Long id);

	public Proveedores editar(Proveedores proveedor);

	public Proveedores eliminar(Long id);

	public List<Proveedores> listar();
	

}
