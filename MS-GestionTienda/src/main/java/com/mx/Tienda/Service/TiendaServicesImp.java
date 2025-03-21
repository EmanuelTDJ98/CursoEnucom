package com.mx.Tienda.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeignClients.IClientesFeign;
import com.mx.Tienda.FeignClients.IProductosFeign;
import com.mx.Tienda.FeignClients.IProveedoresFeign;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Repository.ITiendaRepository;

@Service
@SuppressWarnings("unchecked")
public class TiendaServicesImp implements ITiendaService {
	// -----------------------------------Inyeccion de dependencias
	@Autowired
	private ITiendaRepository repository;

	@Autowired
	private IClientesFeign clientesFC;

	@Autowired
	private RestTemplate restTemplate;

	private IProveedoresFeign proveedoresFC;

	private IProductosFeign productosFC;

//--------------------------------------Servicio de Tienda
	@Override
	public void guardar(Tienda tienda) {
		repository.save(tienda);

	}

	@Override
	public void editar(Tienda tienda) {
		repository.save(tienda);

	}

	@Override
	public Tienda buscar(Integer idTienda) {
		return repository.findById(idTienda).orElse(null);
	}

	@Override
	public void eliminar(Integer idTienda) {
		repository.deleteById(idTienda);

	}

	@Override
	public List<Tienda> listar() {

		return (List<Tienda>) repository.findAll();
	}

	// -------------------------------------------Servicios de Clientes
	public Clientes saveCliente(Clientes cliente) {
		return clientesFC.save(cliente);
	}

	public List<Clientes> getClientes(int tiendaId) {
		return clientesFC.getClientesByTiendaId(tiendaId);
	}

	// -----------------------------------------------Metodos con RestTemplate
	public Clientes saveClienteRT(Clientes cliente) {
		ResponseEntity<Clientes> response = restTemplate.postForEntity("http://localhost:8012/Clientes", cliente,
				Clientes.class);
		return response.getBody();
	}

	public List<Clientes> getClientesRT(int tiendaId) {

		return restTemplate.postForObject("http://localhost:8012/Clientes/tienda/" + tiendaId, null, List.class);

	}

	// ------------------------Servicios de Productos
	public Productos saveProducto(Productos producto) {
		return productosFC.save(producto);
	}

	public List<Productos> buscarProducto(int tiendaId) {
		return restTemplate.getForObject("http://localhost:8010/Productos/tienda/" + tiendaId, List.class);
	}

	public List<Productos> getProductosRT(int tiendaId) {
		return restTemplate.getForObject("http://localhost:8010/Productos/tienda/" + tiendaId, List.class);
	}

	// --------------------------Servicio de Proveedores

	public Proveedores saveProveedores(Proveedores provedor) {
		return proveedoresFC.save(provedor);
	}

	public Proveedores obtenerProveedor(long id) {
		return proveedoresFC.obtenerProveedor(id);
	}

	// Metodos con RestTemplate
	public Proveedores saveProveedoresRT(Proveedores provedor) {
		ResponseEntity<Proveedores> response = restTemplate.postForEntity("http://localhost:8020/Proveedores", provedor,
				Proveedores.class);
		return response.getBody();
	}

	public List<Proveedores> getProveedoresRT(int tiendaId) {
		return restTemplate.postForObject("http://localhost:8020/Proveedores/tienda/" + tiendaId, null, List.class);
	}

	//
	//
	//
	public Map<String, Object> obtenerTodosLosModulos(int tiendaId) {
		Map<String, Object> resultado = new HashMap<>();
		Tienda tienda = this.buscar(tiendaId);
		if (tienda == null) {
			resultado.put("Mensaje", "la tienda ID:" + tiendaId + " NO EXISTE");
			return resultado;
		}
		// validarClientes
		resultado.put("Tienda", tienda);
		List<Clientes> clientes = this.getClientes(tiendaId);
		if (clientes == null || clientes.isEmpty()) {
			resultado.put("Clientes", "La tienda no tiene clientes");
		} else {
			resultado.put("Clientes", clientes);
		}

		// Consutar y validar los productos
		List<Productos> productos = this.buscarProducto(tiendaId);
		if (productos == null || productos.isEmpty()) {
			resultado.put("Productos", "La tienda no tiene productos. ");
		} else {
			resultado.put("Clientes", productos);
		}

		// PROVEEDORES

		List<Proveedores> proveedores = this.getProveedoresRT(tiendaId);
		if (proveedores == null || proveedores.isEmpty()) {
			resultado.put("Proveedores", "la tienda no tiene proveedores");
		} else {
			resultado.put("Proveedores", proveedores);

		}
		return resultado;
	}

}
