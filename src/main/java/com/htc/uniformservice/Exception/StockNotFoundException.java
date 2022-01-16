package com.htc.uniformservice.Exception;

public class StockNotFoundException {
	private String message;

	public StockNotFoundException(String msg) {
		this.message = msg;
	}

	@Override
	public String toString() {
		return "StockFoundException [message=" + message + "]";
	}
}
