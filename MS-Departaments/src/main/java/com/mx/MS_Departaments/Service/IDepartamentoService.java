package com.mx.MS_Departaments.Service;

import java.util.List;

import com.mx.MS_Departaments.Entity.Departamentos;

public interface IDepartamentoService {

	public Departamentos guardar(Departamentos departament);

	public Departamentos buscar(Long idDepartamento);

	public Departamentos editar(Departamentos departament);

	public Departamentos eliminar(Long idDepartamento);

	public List<Departamentos> listar();

}
