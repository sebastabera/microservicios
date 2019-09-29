package com.formacionbdi.springboot.app.items;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Esta clase cumple la funcion de una factory de RestTemplate
 * que es un cliente para trabajar con api rest, un cliente HTTP
 * un cliente para acceder a recursos que estan en otros microservicios
 * @author ltabera
 *
 */
@Configuration
public class AppConfig {

	@Bean
	@LoadBalanced
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
	
}
