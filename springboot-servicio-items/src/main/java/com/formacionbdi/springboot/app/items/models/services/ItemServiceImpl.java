package com.formacionbdi.springboot.app.items.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.items.models.Item;

public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Item> findAll() {
		return null;
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return null;
	}

}
