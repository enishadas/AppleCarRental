package com.enishadas.carrental.service;

import com.enishadas.carrental.model.Car;
import com.enishadas.carrental.model.MetaData;
import com.enishadas.carrental.model.Metrics;
import com.enishadas.carrental.model.PerDayRent;
import com.enishadas.carrental.model.RentalCount;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarReantalService {
	List<Car> rentalCarsList = Arrays.asList(
			new Car("Toyota", "Camry", "VIN9234923923939393393", new MetaData("Blue", "Due for service in June"),
					new PerDayRent(80.0, 10.0), new Metrics(2190.76, 2256.43, new RentalCount(4, 221))),
			new Car("Tesla", "S", "VIN9234923923GFT39393393", new MetaData("Blue", "Damaged bumper"),
					new PerDayRent(150.0, 10.0), new Metrics(2130.76, 2266.43, new RentalCount(3, 222))),
			new Car("Tesla", "T", "VIN923492554423GFT39393393", new MetaData("Blue", "New car"),
					new PerDayRent(100.0, 50.0), new Metrics(2150.76, 2246.43, new RentalCount(5, 223))),
			new Car("Honda", "Accord", "VIN9234GH78FDR39393393",
					new MetaData("Silver", "Booked for entire month of Nov"), new PerDayRent(120.0, 20.0),
					new Metrics(2195.76, 2251.43, new RentalCount(2, 220))));

	public List<Car> getAllRentalCars() {

		return rentalCarsList;
	}
}
