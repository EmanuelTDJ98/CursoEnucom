package com.mx.MS.Proveedores.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROVEEDORES")
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Proveedores {
	
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Long getContacto() {
		return contacto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public int getTiendaId() {
		return tiendaId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID")
	@SequenceGenerator(name = "SEQ_ID", sequenceName ="S_ID", allocationSize = 1)
	private Long id;
	private String nombre;
	private Long contacto;
	private String empresa;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private int tiendaId;

}
