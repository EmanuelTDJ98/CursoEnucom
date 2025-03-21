package com.mx.MS_Trabajador.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.MS_Trabajador.Dao.ITrabajadorDao;
import com.mx.MS_Trabajador.Entity.Trabajador;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrabajadorServiceImp implements ITrabajadorService{
	@Autowired
	private ITrabajadorDao dao;

	@Override
	public Trabajador guardar(Trabajador trabajador) {
		
		return dao.save(trabajador);
	}

	@Override
	public Trabajador editar(Trabajador trabajador) {
		Trabajador aux = this.buscar(trabajador.getIdTrabajador());
		if(aux!=null) {
			dao.save(trabajador);
		}
		return null;
	}

	@Override
	public Trabajador eliminar(Long idTrabajador) {
		Trabajador aux = this.buscar(idTrabajador);
		if(aux != null) {
			dao.deleteById(idTrabajador);
			return aux;
		}
		return null;
	}

	@Override
	public Trabajador buscar(Long idTrabajador) {
		
		return dao.findById(idTrabajador).orElse(null);
	}

	@Override
	public List<Trabajador> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC, "idTrabajador"));
	}
	
	

}
