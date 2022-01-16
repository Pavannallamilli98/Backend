package com.htc.uniformservice.Exception;

public class DuplicatestockIdException extends Exception {
	private String message;

	public DuplicatestockIdException(String msg) {
		this.message = msg;
	}

	@Override
	public String toString() {
		return "stockIdFoundException [message=" + message + "]";
	}
}
