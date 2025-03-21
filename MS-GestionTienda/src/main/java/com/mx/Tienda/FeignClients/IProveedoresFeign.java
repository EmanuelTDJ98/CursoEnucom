package com.mx.Tienda.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Proveedores;

@FeignClient(
		name = "MS-Proveedores",
		url = "http://localhost:8020",
		path = "/Proveedores")


public interface IProveedoresFeign {
	
	//Declaracion de los controladores  de los Microservicios MS.Proveedores
	@PostMapping
	public Proveedores save(@RequestBody Proveedores proveedor);
	
	@PostMapping("/{id}")
	public Proveedores obtenerProveedor(@PathVariable Long id);

}
