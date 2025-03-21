package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Clientes;

@FeignClient(
		name = "MS-Clientes",
		url = "http://localhost:8012",
		path = "/Clientes")

public interface IClientesFeign {
	
	//Declaracion de los controaldores de los microservicios MS-Clientes
	@PostMapping
	public Clientes save(@RequestBody Clientes cliente);
	
	@PostMapping("/tienda/{tiendaId}")
	public List<Clientes> getClientesByTiendaId(@PathVariable int tiendaId);
	

}
