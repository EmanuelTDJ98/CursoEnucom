package com.mx.MS_Departaments.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MS_Departaments.Entity.Departamentos;
@Repository
public interface DepartamentoDao extends JpaRepository<Departamentos, Long>{

}
