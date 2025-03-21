package com.mx.MS.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.MS.Proveedores.Entity.Proveedores;
import com.mx.MS.Proveedores.Service.ProveedoresServiceImp;

@RestController
@RequestMapping("/Proveedores")
public class ProveedoresWS {
//"http://localhost:8020/Proveedores/tienda/"
	@Autowired
	private ProveedoresServiceImp service;

	@PostMapping("/tienda/{tiendaId}")
	public ResponseEntity<?> obtenerPortiendaId(@PathVariable int tiendaId){
		List<Proveedores> proveedores = service.buscarPorTienda(tiendaId);
		
		return ResponseEntity.ok(proveedores);
	
		
	}
	
	
	// End Point Listar
	@GetMapping ResponseEntity<?> listarProveedores() {
		List<Proveedores> proveedores = service.listar();
		if (proveedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(proveedores);
	}

	// EndPotin Buscar
	@PostMapping("/{id}")
	public ResponseEntity<?> obtenerProveedores(@PathVariable Long id) {
		Proveedores proveedor = service.buscar(id);
		if (proveedor != null) {
			return ResponseEntity.ok(proveedor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// End Point de Guardar
	@PostMapping  
	public ResponseEntity<?> guardarProveedores(@RequestBody Proveedores proveedor) {
		return ResponseEntity.ok(service.guardar(proveedor));
	}

	// End Point de Actualizar
	@PutMapping
	public ResponseEntity<?> actualizarProveedores(@RequestBody Proveedores proveedor) {
		Proveedores proveedoresDB = service.buscar(proveedor.getId());
		if (proveedoresDB != null) {
			return ResponseEntity.ok(service.editar(proveedoresDB));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProveedores(@PathVariable Long id) {
		Proveedores prov = service.buscar(id);
		if (prov != null) {
			service.eliminar(id);
			return ResponseEntity.ok(prov);
		} else {
			return ResponseEntity.notFound().build();
		}
		

	}

}
