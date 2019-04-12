package com.enishadas.carrental.service;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.enishadas.carrental.model.Car;

@RunWith(SpringRunner.class)
public class CarRentalServiceTest {

	@Test
	public void testPrintBlueTeslas() {
		System.out.println("Question 1");
		List<Car> cars = getResponse();

		for (Car car : cars) {
			System.out.println("car=" + car);
			if ("Tesla".equals(car.getMake()) && "Blue".equals(car.getMetaData().getColor())) {
				System.out.println("Blue Tesla vin=" + car.getVin() + ", notes=" + car.getMetaData().getNotes());
			}
		}
	}

	@Test
	public void getLowestPerDayRentalCars() {
		List<Car> cars = getResponse();
		double lowestPrice = Double.MAX_VALUE;
		double lowestDiscountedPrice = Double.MAX_VALUE;
		List<Car> lowestPricedCars = new LinkedList<Car>();
		List<Car> lowestDiscountedPricedCars = new LinkedList<Car>();
		System.out.println("Question 2");
		getResponse();
		for (Car car : cars) {
			double carPrice = car.getPerDayRent().getPrice();
			if (carPrice < lowestPrice) {
				lowestPricedCars.clear();
				lowestPrice = carPrice;
				lowestPricedCars.add(car);
			} else if (carPrice == lowestPrice) {
				lowestPricedCars.add(car);
			}

			// here we are checking the lowest discounted priced cars
			double carDiscountedPrice = carPrice - (carPrice * car.getPerDayRent().getDiscount()) / 100;
			if (carDiscountedPrice < lowestDiscountedPrice) {
				lowestDiscountedPricedCars.clear();
				lowestDiscountedPrice = carDiscountedPrice;
				lowestDiscountedPricedCars.add(car);
			} else if (carDiscountedPrice == lowestDiscountedPrice) {
				lowestDiscountedPricedCars.add(car);
			}

		}
		System.out.println("The cars with lowest prices are : " + lowestPricedCars);
		System.out.println("The cars with lowest discounted prices are : " + lowestDiscountedPricedCars);
	}

	@Test
	public void getHighestProfitMakingRentalCars() {
		List<Car> cars = getResponse();
		double highestProfit = Double.MIN_VALUE;
		List<Car> highestProfitMakingCars = new LinkedList<Car>();
		System.out.println("Question 3");
		for (Car car : cars) {
			double carPrice = car.getPerDayRent().getPrice();
			double carDiscountedPrice = carPrice - (carPrice * car.getPerDayRent().getDiscount()) / 100;
			double totalRevenue = car.getMetrics().getRentalCount().getYeartodate() * carDiscountedPrice;
			double totalProfit = totalRevenue - car.getMetrics().getDepreciation()
					- car.getMetrics().getYoymaintenancecost();
			System.out.println("totalProfit = " + totalProfit);
			if (totalProfit > highestProfit) {
				highestProfitMakingCars.clear();
				highestProfit = totalProfit;
				highestProfitMakingCars.add(car);
			} else if (totalProfit == highestProfit) {
				highestProfitMakingCars.add(car);
			}

		}
		System.out.println("The cars with highest profits are : " + highestProfitMakingCars);
	}

	public List<Car> getResponse() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Car>> response = restTemplate.exchange("http://localhost:8090/cars", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Car>>() {
				});

		List<Car> cars = response.getBody();
		return cars;
	}

}
