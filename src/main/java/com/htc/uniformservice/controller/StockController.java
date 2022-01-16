package com.htc.uniformservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.uniformservice.Exception.DuplicatestockIdException;
import com.htc.uniformservice.model.Stock;
import com.htc.uniformservice.service.StockService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class StockController {

	@Autowired
	private StockService stockService;

	/* For Adding the details */
	@PostMapping(value = "/stock", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addstock(@RequestBody Stock stock) throws DuplicatestockIdException {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "POST");
		headers.add("Access-Control-Allow-Headers", "Content-Type");

		return new ResponseEntity<String>(stockService.addstock(stock), headers, HttpStatus.CREATED);
	}
    /* To show list of stocks */
	@GetMapping(value = "/stock", consumes = MediaType.ALL_VALUE)
	public List<Stock> listallStock() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET");
		headers.add("Access-Control-Allow-Headers", "Content-Type");

		return (stockService.listallStock());
	}
 
	/* updating the stock*/
	@PutMapping(path = "/stock", consumes = "application/json", produces = "application/json")
	public Stock updateStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}

	/* Deleting the stock */
	@DeleteMapping(path = "/stock/{stockId}", produces = "application/json")
	public String deleteById(@PathVariable int stockId) {
		return stockService.deleteById(stockId);
	}

	/* search the stock by Id */
	@GetMapping(value = "/getstock/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stock> getStock(@PathVariable(name = "stockId") int stockId) {
		Stock stock = stockService.getStock(stockId);		
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}
}
