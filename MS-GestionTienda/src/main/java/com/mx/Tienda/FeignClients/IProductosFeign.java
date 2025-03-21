package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mx.Tienda.Models.Productos;

@FeignClient(
		name = "MS-Productos",
		url = "http://localhost:8010",
		path = "/Productos")

public interface IProductosFeign {
	//Declaracion de los controladores de los microservicios MS-Productos
	@PostMapping
	public Productos save(@PathVariable Productos producto);
	
	@GetMapping("/tienda/{tiendaId}")
	public List<Productos> buscarPorTiendaId(@PathVariable int tiendaId);

}
