package com.mx.MS_Job_Titles.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.MS_Job_Titles.Dao.TitulosDao;
import com.mx.MS_Job_Titles.Entity.Titulos;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class TitulosServiceImp implements ITitulosService{

	@Autowired
	private TitulosDao dao;
	
	@Override
	public Titulos guardar(Titulos titulo) {
		
		return dao.save(titulo);
	}

	@Override
	public Titulos editar(Titulos titulo) {
		Titulos aux = this.buscar(titulo.getIdTitulos());
		if(aux != null) {
			dao.save(titulo);
		}
		return null;
	}

	@Override
	public Titulos buscar(Long idTitulos) {

		return dao.findById(idTitulos).orElse(null);
	}

	@Override
	public Titulos eliminar(Long idTitulos) {
		Titulos aux = this.buscar(idTitulos);
		if(aux != null) {
			dao.deleteById(idTitulos);
			return aux;
		}
		return null;
	}

	@Override
	public List<Titulos> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC, "idTitulos"));
	}

}
