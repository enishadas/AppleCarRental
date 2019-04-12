package com.enishadas.carrental.controller;

import com.enishadas.carrental.model.Car;
import com.enishadas.carrental.service.CarReantalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRentalController {

	@Autowired
	private CarReantalService carReantalService;

	@RequestMapping("/cars")
	public List<Car> getCars() {
		return carReantalService.getAllRentalCars();
	}
}
