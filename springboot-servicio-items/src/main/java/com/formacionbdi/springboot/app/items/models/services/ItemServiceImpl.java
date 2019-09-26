package com.formacionbdi.springboot.app.items.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formacionbdi.springboot.app.items.models.Item;
import com.formacionbdi.springboot.app.items.models.dao.ItemDao;

public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> findAll() {
		return (List<Item>) itemDao.findAll();
	}

	@Override
	public Item findById(Long id) {
		return itemDao.findById(id).orElse(null);
	}

}
