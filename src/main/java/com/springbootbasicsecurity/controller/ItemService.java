package com.springbootbasicsecurity.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.springbootbasicsecurity.entity.Itemm;

@Service
public class ItemService {
	Logger logger = Logger.getLogger(ItemService.class);
	@Autowired
	ItemRepository repository;
	
	public List<Itemm> getAllItems() {
		return repository.findAll();
	}

	public Itemm getOneItem(@RequestHeader int item) {
		 Itemm findById = repository.getById(item);
		return findById;
	}
	
	public Itemm createItem(@RequestBody Itemm item) {
		repository.save(item);
		return item;
	}
	
//	public ResponseEntity<String> updateItem(@RequestHeader String item) {
//		//repository.save(null)
//		return new ResponseEntity<String>("Itemm got updated", HttpStatus.CREATED);
//	}
	
	public void deleteItem(@RequestHeader int item) {
       repository.deleteById(item);
	}

}
