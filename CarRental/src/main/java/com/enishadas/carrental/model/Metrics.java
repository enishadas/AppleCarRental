package com.enishadas.carrental.model;

public class Metrics {
	private double yoymaintenancecost;
	private double depreciation;

	private RentalCount rentalCount;

	public Metrics() {

	}

	public Metrics(double yoymaintenancecost, double depreciation, RentalCount rentalCount) {
		super();
		this.yoymaintenancecost = yoymaintenancecost;
		this.depreciation = depreciation;
		this.rentalCount = rentalCount;
	}

	public double getYoymaintenancecost() {
		return yoymaintenancecost;
	}

	public void setYoymaintenancecost(double yoymaintenancecost) {
		this.yoymaintenancecost = yoymaintenancecost;
	}

	public double getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
	}

	public RentalCount getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(RentalCount rentalCount) {
		this.rentalCount = rentalCount;
	}
}
