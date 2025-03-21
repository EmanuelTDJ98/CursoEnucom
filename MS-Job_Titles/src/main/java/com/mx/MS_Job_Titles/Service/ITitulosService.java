package com.mx.MS_Job_Titles.Service;

import java.util.List;

import com.mx.MS_Job_Titles.Entity.Titulos;

public interface ITitulosService {
	public Titulos guardar(Titulos titulo);

	public Titulos editar(Titulos titulo);

	public Titulos buscar(Long idTitulos);

	public Titulos eliminar(Long idTitulos);

	public List<Titulos> listar();

}
