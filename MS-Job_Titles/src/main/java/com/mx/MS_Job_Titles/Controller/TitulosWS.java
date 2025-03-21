package com.mx.MS_Job_Titles.Controller;

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

import com.mx.MS_Job_Titles.Entity.Titulos;
import com.mx.MS_Job_Titles.Service.TitulosServiceImp;

@RestController
@RequestMapping("Titulos")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TitulosWS {

	@Autowired
	private TitulosServiceImp service;

	@GetMapping
	public List<Titulos> listar() {
		return service.listar();
	}

	@PostMapping(value = "buscar/{idTitulos}")
	public Titulos buscar(@PathVariable Long idTitulos) {
		return service.buscar(idTitulos);

	}

	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Titulos titulo) {
		service.guardar(titulo);
	}

	@PutMapping(value = "editar/{idTitulos}")
	public void editar(@RequestBody Titulos titulo) {
		service.editar(titulo);
	}

	@DeleteMapping(value = "eliminar/{idTitulos}")
	public void eliminar(@PathVariable Long idTitulos) {
		service.eliminar(idTitulos);
	}

}
