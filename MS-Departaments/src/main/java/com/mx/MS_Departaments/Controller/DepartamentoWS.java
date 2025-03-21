package com.mx.MS_Departaments.Controller;

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

import com.mx.MS_Departaments.Entity.Departamentos;
import com.mx.MS_Departaments.Service.DepartamentoServiceImp;

@RestController
@RequestMapping("/Departamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoWS {
	@Autowired
	private DepartamentoServiceImp service;

	// Listar todos los departamentos existentes
	@GetMapping
	public List<Departamentos> listar() {
		return service.listar();
	}

	@PostMapping(value = "buscar/{idDepartamento}")
	public Departamentos buscar(@PathVariable Long idDepartamento) {
		return service.buscar(idDepartamento);
	}

	@PostMapping(value = "guardar")
	public Departamentos guardar(@RequestBody Departamentos departament) {

		return service.guardar(departament);

	}

	@PutMapping(value = "editar/{idDepartamento}")
	public Departamentos editar(@RequestBody Departamentos departament) {
		return service.editar(departament);
	}

	@DeleteMapping(value = "eliminar/{idDepartamento}")
	public void eliminar(@PathVariable Long idDepartamento) {
		 service.eliminar(idDepartamento);
	}

}
