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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock implements Serializable {

	@Id
	@Column(name="stockId")
	private int stockId;
	private String uniformItem;
	private String uniformType;
	private int quantityOnHand;
	private int unitPrice;
	private String size;
	private String status;
	@ManyToOne
	@JoinColumn(name = "vendorId")
	private Vendor vendor;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(String uniformItem, String uniformType, int quantityOnHand, int unitPrice, String size, String status
			) {
		super();
		this.uniformItem = uniformItem;
		this.uniformType = uniformType;
		this.quantityOnHand = quantityOnHand;
		this.unitPrice = unitPrice;
		this.size = size;
		this.status = status;
		
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getUniformItem() {
		return uniformItem;
	}

	public void setUniformItem(String uniformItem) {
		this.uniformItem = uniformItem;
	}

	public String getUniformType() {
		return uniformType;
	}

	public void setUniformType(String uniformType) {
		this.uniformType = uniformType;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return stockId == other.stockId;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", uniformItem=" + uniformItem + ", uniformType=" + uniformType
				+ ", quantityOnHand=" + quantityOnHand + ", unitPrice=" + unitPrice + ", size=" + size + ", status="
				+ status + ", vendorId=" + vendor+ "]";
	}
}
