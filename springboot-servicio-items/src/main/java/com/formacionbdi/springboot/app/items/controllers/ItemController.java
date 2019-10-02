package com.formacionbdi.springboot.app.items.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.items.models.Item;
import com.formacionbdi.springboot.app.items.models.Producto;
import com.formacionbdi.springboot.app.items.models.services.IItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	private IItemService itemService;

	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}

	/**
	 * anotacion @HystrixCommand es para crear un circuito alternativo cuando halla
	 * un error
	 * 
	 * @param id
	 * @param cantidad
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item ver(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		producto.setNombre("Camara sony");
		producto.setId(id);
		producto.setPrecio(500.00);
		item.setProducto(producto);
		item.setCantidad(cantidad);
		
		return item;
		
	}

}
