package com.mx.MS_Job_Titles.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "TITULOS")
public class Titulos {
	@Id
	private Long idTitulos;
	private String nombre;
	private Long idDepartamento;

}
