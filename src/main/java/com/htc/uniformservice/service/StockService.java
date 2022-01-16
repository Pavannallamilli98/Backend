package com.htc.uniformservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.uniformservice.Exception.DuplicatestockIdException;
import com.htc.uniformservice.Exception.StockNotFoundException;
import com.htc.uniformservice.model.Stock;
import com.htc.uniformservice.repository.StockRepository;

//For using crud operations
@Service("stockService")
public class StockService {

	@Autowired     //getters and setters injection
	private StockRepository stockrepository;

	/* adding stock */
	@Transactional  
	public String addstock(Stock stock) throws DuplicatestockIdException {
		System.out.println(stock);
		if (stockrepository.save(stock) != null) {
			return "stock details created";
		}
		if (stock.getStockId() == stock.getStockId())
			throw new DuplicatestockIdException("stock Not Found");
		return "Problem in creating product details";
	}

	/* update stock */
	@Transactional
	public Stock updateStock(Stock stock) {
		return stockrepository.save(stock);
	}

	/* show the list of stock */
	@Transactional
	public List<Stock> listallStock() {
		return (List<Stock>) stockrepository.findAll();
	}

	/* delete the stock by id */
	@Transactional
	public String deleteById(int stockId) {
		stockrepository.deleteById(stockId);
		return "stock was deleted successfully";
	}

	/* searching stock */
	@Transactional
	public Stock getStock(int stockId) {
		// TODO Auto-generated method stub
		Optional<Stock> stockopt = stockrepository.findById(stockId);
		Stock stock=new Stock();
		if (stockopt.isPresent()) {
			return stockopt.get();
		}
		return stock;
	}
}


