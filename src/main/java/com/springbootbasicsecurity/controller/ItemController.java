package com.springbootbasicsecurity.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbasicsecurity.entity.Itemm;
import com.springbootbasicsecurity.exception.InvalidUserException;
import com.springbootbasicsecurity.exception.ItemNotFoundException;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping(path = "/api/v1" )
public class ItemController {
	Logger logger = Logger.getLogger(ItemController.class);
	@Autowired
	ItemService service;

	
	@GetMapping(path = "/items")//sort
	public ResponseEntity<?> getAllItems() {
		return new ResponseEntity<List<Itemm>>(service.getAllItems(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/items?sort=name_asc")//sort
	public String getAllItemsSorted() {
		return "Hi Get controller and spring basix security worked!!!!";
	}
	
	@GetMapping(path = "/items?name=cloth")//filter
	public String getAllItemsFiltered() {
		return "Hi Get controller and spring basix security worked!!!!";
	}
	
	@GetMapping(path = "/items?page=23")//filter
	public String getAllItemsPagination() {
		return "Hi Get controller and spring basix security worked!!!!";
	}

	@ApiOperation("method used to find by name")
	@GetMapping(path = "/items/{item}")
	public ResponseEntity<?> getOneItem(@RequestParam int item) {

		if (item ==  10) {
			logger.error("Itemm not found, please give correct one...");
			throw new ItemNotFoundException();
		}
		if (item <= 0) {
			logger.error("Itemm not valid...");
			throw new InvalidUserException();
		}
		return new ResponseEntity<Itemm>(service.getOneItem(item), HttpStatus.OK);
	}
	
	@ApiOperation("method used to create Itemm")
	@PostMapping(path = "/items")
	public ResponseEntity<String> createItem(@RequestBody Itemm item) {

		if (item.getId() > 10) {
			logger.error("Itemm not found, please give correct one...");
			throw new ItemNotFoundException();
		}
		service.createItem(item);
		return new ResponseEntity<String>("Itemm got created", HttpStatus.CREATED);
	}
	
//	@ApiOperation("method used to find by name")
//	@PutMapping(path = "/items/{item}")
//	public ResponseEntity<String> updateItem(@RequestHeader String item) {
//
//		if (item.length() > 10) {
//			logger.error("Itemm not found, please give correct one...");
//			throw new ItemNotFoundException();
//		}
//		
//		return new ResponseEntity<String>("Itemm got updated", HttpStatus.CREATED);
//	}
	
	@ApiOperation("method used to delete by name")
	@DeleteMapping(path = "/items/{item}")
	public ResponseEntity<String> deleteItem(@RequestHeader int item) {

		if (item == 0) {
			logger.error("Itemm not found, please give correct one...");
			throw new ItemNotFoundException();
		}
		service.deleteItem(item);
		return new ResponseEntity<String>("Itemm deleted", HttpStatus.NO_CONTENT);
	}
	
    //Payconiq
	/*
	 * @GetMapping(value = "/healthcheck") public ResponseEntity<?>
	 * healthcheck(@RequestParam String format) {
	 * 
	 * Response1 res = new Response1(); if (format.equalsIgnoreCase("short")) {
	 * res.setStatus(HttpStatus.OK.value()); return new
	 * ResponseEntity<Response1>(res, HttpStatus.OK); } else if
	 * (format.equalsIgnoreCase("full")) { res.setStatus(HttpStatus.OK.value());
	 * res.setDate(new Date()); return
	 * ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).
	 * body(res); } return ResponseEntity.badRequest().build(); }
	 * 
	 * @PutMapping(value = "/healthcheck") public ResponseEntity<?> healthcheckPut()
	 * { return new ResponseEntity<String>("PUT method is not allowed",
	 * HttpStatus.METHOD_NOT_ALLOWED); }
	 * 
	 * @PostMapping(value = "/healthcheck") public ResponseEntity<?>
	 * healthcheckPost() { return new
	 * ResponseEntity<String>("POST method is not allowed",
	 * HttpStatus.METHOD_NOT_ALLOWED); }
	 * 
	 * @DeleteMapping(value = "/healthcheck") public ResponseEntity<?>
	 * healthcheckDelete() { return new
	 * ResponseEntity<String>(HttpStatus.METHOD_NOT_ALLOWED); }
	 * 
	 * @JsonIgnoreProperties(ignoreUnknown = true)
	 * 
	 * @JsonInclude(JsonInclude.Include.NON_NULL) class Response1 { int status;
	 * 
	 * @JsonIgnoreProperties Date date;
	 * 
	 * public int getStatus() { return status; }
	 * 
	 * public void setStatus(int status) { this.status = status; }
	 * 
	 * public Date getDate() { return date; }
	 * 
	 * public void setDate(Date date) { this.date = date; }
	 * 
	 * }
	 */



}
