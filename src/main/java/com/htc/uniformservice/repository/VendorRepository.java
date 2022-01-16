package com.htc.uniformservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.uniformservice.model.Vendor;

	@Repository
	public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
