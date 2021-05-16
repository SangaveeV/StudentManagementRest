package com.student.management.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String line;
	private String city;
	private String state;
	private int pinCode;
	public Address() {
		super();
	}
	public Address(String line, String city, String state, int pinCode) {
		super();
		this.line = line;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [line=" + line + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}

}
