package com.mx.ATM.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

public class Usuario {
	@Id
	private Long idUsuario;
	private String nombre;
	private int numeroTarjeta;
	private Long cuentId;

}
