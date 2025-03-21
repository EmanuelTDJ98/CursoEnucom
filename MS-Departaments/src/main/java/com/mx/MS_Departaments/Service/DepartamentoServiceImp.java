package com.mx.MS_Departaments.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.MS_Departaments.Dao.DepartamentoDao;
import com.mx.MS_Departaments.Entity.Departamentos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartamentoServiceImp implements IDepartamentoService {

	@Autowired
	private DepartamentoDao dao;

	@Override
	public Departamentos guardar(Departamentos departament) {

		return dao.save(departament);
	}

	@Override
	public Departamentos buscar(Long idDepartamento) {
		return dao.findById(idDepartamento).orElse(null);
	}

	@Override
	public Departamentos editar(Departamentos departament) {
		Departamentos aux = this.buscar(departament.getIdDepartamento());
		if (aux != null) {
			 dao.save(departament);
		}
		return null;
	}

	@Override
	public Departamentos eliminar(Long idDepartamento) {
		Departamentos aux = this.buscar(idDepartamento);
		if (aux != null) {
			dao.deleteById(idDepartamento);
			return aux;
		}
		return null;
	}

	@Override
	public List<Departamentos> listar() {

		return dao.findAll(Sort.by(Direction.DESC, "idDepartamento"));
	}

}
