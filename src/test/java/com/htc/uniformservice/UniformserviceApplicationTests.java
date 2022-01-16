package com.htc.uniformservice;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.htc.uniformservice.model.Stock;
import com.htc.uniformservice.repository.StockRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UniformserviceApplicationTests {


	@Autowired
	private StockRepository stockrepository;

	@Test // create and save the stock
	@Order(1)
	public void testCreate() {
		Stock stock = new Stock();
		stock.setStockId(42);
		stock.setUniformItem("shirt");
		stock.setUniformType("yellow");
		stock.setQuantityOnHand(9);
		stock.setUnitPrice(9000);
		stock.setSize("xl");
		stock.setStatus("finished");
		stockrepository.save(stock);
		assertNotNull(stockrepository.findById(3).get());

	}

	@Test  //for update method
	@Order(2)
	public void testUpdate() {
		Stock stock = stockrepository.findById(42).get();
		stock.setUnitPrice(4700);
		stockrepository.save(stock);
		assertNotEquals(15000, stockrepository.findById(42).get().getUnitPrice());
	}

	@Test  //for delete method
	@Order(3)
	public void testDelete() {
		stockrepository.deleteById(42);	
	}
	
	@Test  //for list method
	@Order(4)
	public void testList() {
		stockrepository.findAll();
	}
	
	@Test  //for searching method
	@Order(5)
	public void testSearch() {
		stockrepository.getById(41);
	}	
}