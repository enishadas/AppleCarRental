package com.enishadas.carrental.model;

public class RentalCount {
	private int lastweek;
	private int yeartodate;

	public RentalCount() {

	}

	public RentalCount(int lastweek, int yeartodate) {
		super();
		this.lastweek = lastweek;
		this.yeartodate = yeartodate;
	}

	public int getLastweek() {
		return lastweek;
	}

	public void setLastweek(int lastweek) {
		this.lastweek = lastweek;
	}

	public int getYeartodate() {
		return yeartodate;
	}

	public void setYeartodate(int yeartodate) {
		this.yeartodate = yeartodate;
	}
}
