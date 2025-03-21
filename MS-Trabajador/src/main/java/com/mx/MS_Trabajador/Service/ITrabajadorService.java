package com.mx.MS_Trabajador.Service;

import java.util.List;

import com.mx.MS_Trabajador.Entity.Trabajador;

public interface ITrabajadorService {

	public Trabajador guardar(Trabajador trabajador);

	public Trabajador editar(Trabajador trabajador);

	public Trabajador eliminar(Long idTrabajador);

	public Trabajador buscar(Long idTrabajador);

	public List<Trabajador> listar();

}
