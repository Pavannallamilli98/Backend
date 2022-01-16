package com.htc.uniformservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.uniformservice.Exception.DuplicatestockIdException;
import com.htc.uniformservice.model.Stock;
import com.htc.uniformservice.model.Vendor;
import com.htc.uniformservice.service.StockService;
import com.htc.uniformservice.service.VendorService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController
	@RequestMapping("api/")
	public class VendorController {

		@Autowired
		private VendorService vendorService;

		/* For Adding the details */
		@PostMapping(value = "/vendor", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addvendor(@RequestBody Vendor vendor) throws DuplicatestockIdException {

			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Methods", "POST");
			headers.add("Access-Control-Allow-Headers", "Content-Type");

			return new ResponseEntity<String>(vendorService.addvendor(vendor), headers, HttpStatus.CREATED);
		}
		@GetMapping(value = "/vendor", consumes = MediaType.ALL_VALUE)
		public List<Vendor> listallVendor() {

			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Methods", "GET");
			headers.add("Access-Control-Allow-Headers", "Content-Type");

			return (vendorService.listallVendor());
		}
		
		@GetMapping(value = "/getvendor/{vendorId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Vendor> getVendor(@PathVariable(name = "vendorId") int vendorId) {
			Vendor vendor = vendorService.getVendor(vendorId);		
			return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
		}
}
