package com.htc.uniformservice.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="vendor")
public class Vendor implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vendorserviceid")
	
	private int vendorId;
	private String vendorName;
	private int contactNo;
	private String address;
	public Vendor() {
		// TODO Auto-generated constructor stub
	}
	public Vendor( String vendorName, int contactNo, String address) {
		super();
		this.vendorName = vendorName;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(vendorId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		return vendorId == other.vendorId;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", contactNo=" + contactNo + ", address="
				+ address + "]";
	}
}