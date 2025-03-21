package com.mx.Tienda.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateConfig {
	
	/*
	 * @Bean
	 * 
	 * que es @Bean: en spring boot es una notacion que se va  utilizar dentro de una clase de configuracion
	 * (@Configuration) para indicar que un metodo produce un "BEAN" que sera administrado por el contenedor de
	 * instancias de  Spring.
	 * 
	 * que es un "BEAN" En spring es un objeto ue forma parte del contexto de la aplicacion ademas es 
	 * adminsitrado por el contenedor de instancias del Spring estos objetos pueden ser inyectados en otras partes 
	 * del codigo mediante la "Iyeccion de Dependencias"
	 * Resumiendo un bean es una unica isntancia que se encuentra almacenada en el contenedor de Instancias de spring framework
	 * Esto para garantizar que solo exista una sola instancia de ese Objecto
	 * */
	@Bean
	RestTemplate resTemplate() {
		return new RestTemplate();
	}

}
