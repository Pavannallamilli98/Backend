package com.htc.uniformservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.uniformservice.Exception.DuplicatestockIdException;
import com.htc.uniformservice.model.Stock;
import com.htc.uniformservice.model.Vendor;
import com.htc.uniformservice.repository.VendorRepository;

@Service("vendorService")
public class VendorService {

	@Autowired
	VendorRepository vendorrepository;

	@Transactional
	public String addvendor(Vendor vendor) throws DuplicatestockIdException {
		if (vendorrepository.save(vendor) != null) {
			return "vendor details created";
		}
		if (vendor.getVendorId() == vendor.getVendorId())
			throw new DuplicatestockIdException("vendor Not Found");
		return "Problem in creating product details";
	}

	@Transactional
	public List<Vendor> listallVendor() {
		return (List<Vendor>) vendorrepository.findAll();
	}

	@Transactional
	public Vendor getVendor(int vendorId) {
		// TODO Auto-generated method stub
		Optional<Vendor> vendoropt = vendorrepository.findById(vendorId);
		Vendor vendor = new Vendor();
		if (vendoropt.isPresent()) {
			return vendoropt.get();
		}
		return vendor;
	}
}
