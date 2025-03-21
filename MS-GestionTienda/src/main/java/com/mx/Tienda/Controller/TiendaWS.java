package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Service.TiendaServicesImp;

@RestController
@RequestMapping(path = "/Tienda")
public class TiendaWS {
	@Autowired
	private TiendaServicesImp service;

	@GetMapping(value = "listar")
	public List<Tienda> listar() {
		return service.listar();
	}

	@PostMapping(value = "buscar/{idTienda}")
	public Tienda buscar(@PathVariable int idTienda) {
		return service.buscar(idTienda);
	}

	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Tienda tienda) {
		service.guardar(tienda);
 

	}

	@PutMapping(value = "editar/{idTienda}")
	public void editar(@RequestBody Tienda tienda) {
		service.editar(tienda);
	}

	@DeleteMapping(value = "eliminar/{idTienda}")
	public void eliminar(@PathVariable int idTienda) {
		service.eliminar(idTienda);
	}

	// EndPoint Guardar Cliente
	// http:/localhost:
	@PostMapping("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientes cliente) {
		Clientes nuevoCliente = service.saveCliente(cliente);
		if (nuevoCliente == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);

	}

	@GetMapping("/Clientes/{tiendaId}")
	public ResponseEntity<?> obtenerClientes(@PathVariable int tiendaId) {
		List<Clientes> clientes = service.getClientes(tiendaId);
		if (clientes == null || clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}

	// Productos
	@PostMapping("/Productos")
	public ResponseEntity<?> guardarProducto(@RequestBody Productos producto) {
		Productos nuevoProductos = service.saveProducto(producto);
		if (nuevoProductos == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProductos);

	}

	@GetMapping("/Productos/{tiendaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int tiendaId) {
		List<Productos> productos = service.getProductosRT(tiendaId);
		if (productos == null || productos.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(productos);
	}

	// -----------------------------------------Proveedores
	// EndPoint Guardar PROVEEDORES
	// http://localhost:puerto/Tienda/Proveedores
	@PostMapping("/Proveedores")
	public ResponseEntity<?> guardarProveedores(@RequestBody Proveedores proveedor) {
		Proveedores nuevoProveedor = service.saveProveedores(proveedor);
		if (nuevoProveedor == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);

	}

	@GetMapping("/Proveedores/{tiendaId}")
	public ResponseEntity<?> obtenerProveedores(@PathVariable int tiendaId) {
		List<Proveedores> proveedores = service.getProveedoresRT(tiendaId);
		if(proveedores.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		return ResponseEntity.status(HttpStatus.OK).body(proveedores);
		

	}

	// ********************************************************************
	// Metodo para obtener toda la realcion de la tienda y sus Modulos
	// (Mcroservicios)
	// http://localhost:8014/Tienda/todo/{tiendaId}
	// *********************************************************************
	@GetMapping("/todo/{tiendaId}")
	public ResponseEntity<?> obtenerTodosLosModulos(@PathVariable int tiendaId) {
		Map<String, Object> modulos = service.obtenerTodosLosModulos(tiendaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
	}

}
