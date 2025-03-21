package com.mx.MS_Departaments.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
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
@Table(name="DEPARTAMENTOS")
public class Departamentos {
	
	@Id
	private Long idDepartamento;
	private String area;
	private String nombre;
	private Long telefono;
	private String direccion;
}
