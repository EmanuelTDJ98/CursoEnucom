package com.mx.MS.Proveedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.MS.Proveedores.Dao.IProveedoresDao;
import com.mx.MS.Proveedores.Entity.Proveedores;

@Service
public class ProveedoresServiceImp implements IProveedorService {
	
	@Autowired
	private IProveedoresDao dao;

	@Override
	public Proveedores guardar(Proveedores proveedor) {
		return dao.save(proveedor);
	}

	@Override
	public Proveedores buscar(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Proveedores editar(Proveedores proveedor) {
		Proveedores aux = this.buscar(proveedor.getId());
		if(aux != null) {
			return dao.save(proveedor);
		}
		return null;
	}

	@Override
	public Proveedores eliminar(Long id) {
		Proveedores aux = this.buscar(id);
		if(aux != null) {
			dao.deleteById(id);
		}
		return null;
	}

	@Override
	public List<Proveedores> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC, "id"));
	}

	public List<Proveedores> buscarPorTienda(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}
	
}
