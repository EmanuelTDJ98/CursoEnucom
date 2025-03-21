package com.mx.MS_Trabajador.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.MS_Trabajador.Entity.Trabajador;
import com.mx.MS_Trabajador.Service.TrabajadorServiceImp;

@RestController
@RequestMapping("/Trabajador")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrabajadorWS {
	
	@Autowired
	private TrabajadorServiceImp service;
	
	//Metodo GET para obtener toda la lista de los Trabajadores
	//http://localhost:8031/Trabajador
	@GetMapping
	public List<Trabajador> listar(){
		return service.listar();		
	}
	
	@PostMapping(value = "buscar/{idTrabajador}")
	public Trabajador buscar(@PathVariable Long idTrabajador) {
		return service.buscar(idTrabajador);
	}
	
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Trabajador trabajador) {
		service.guardar(trabajador);
	}
	
	@PutMapping(value = "editar/{idTrabajador}")
	public void editar(@RequestBody Trabajador trabajador) {
		service.editar(trabajador);
	}
	
	@DeleteMapping(value = "eliminar/{idTrabajador}")
	public void eliminar(@PathVariable Long idTrabajador) {
		service.eliminar(idTrabajador);
	}

}
