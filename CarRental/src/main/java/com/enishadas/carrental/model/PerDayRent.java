package com.enishadas.carrental.model;

public class PerDayRent {
	private double price;
	private double discount;

	public PerDayRent() {

	}

	public PerDayRent(double price, double discount) {
		this.price = price;
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
