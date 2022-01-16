package com.htc.uniformservice.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.uniformservice.model.Stock;

//for using interfaces
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	/*
	 * @Modifying
	 * 
	 * @Query("Update uniform SET unitPrice = :UnitPrice WHERE stockId = :StockId")
	 * public boolean updateStock(@Param("stockId") int StockId, @Param("unitPrice")
	 * double unitprice);
	 */

}
