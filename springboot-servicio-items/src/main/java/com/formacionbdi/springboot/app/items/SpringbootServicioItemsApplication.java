package com.formacionbdi.springboot.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * la anotación @EnableCicuitBreaker habilita hystrix
 */
@EnableCircuitBreaker
/**
 * la anotacion @EnableEurekaClient no es obligatoria agregarla ya que al tenerla en el pom
 * se tiene automaticamente
 * 
 * @author lstabera
 *
 */
@EnableEurekaClient
/**
 * se quita la anotacion @RibbonClient ya que esto viene configurado en el servidor de eureka
 * @author lstabera
 *
 */
//@RibbonClient(name="servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemsApplication.class, args);
	}

}
