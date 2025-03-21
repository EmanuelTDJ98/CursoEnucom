package com.mx.MS_Job_Titles.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MS_Job_Titles.Entity.Titulos;

@Repository
public interface TitulosDao extends JpaRepository<Titulos, Long>{

}
