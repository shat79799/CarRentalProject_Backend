package com.demo.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	@Autowired
	private CarRepository carRepo;
	
	@GetMapping()
	public ResponseEntity<List<Car>> getAll() {
		List<Car> listData = carRepo.findAll();
		
		return ResponseEntity.ok(listData);
	}
	
	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<Car>> findByBrand(@PathVariable("brand")String brand) {
		List<Car> listData = carRepo.findAll().stream()
				.filter(c -> c.getBrand().equalsIgnoreCase(brand))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listData);
	}
	
	@GetMapping("/model/{model}")
	public ResponseEntity<List<Car>> findByModel(@PathVariable("model")String model) {
		List<Car> listData = carRepo.findAll().stream()
				.filter(c -> c.getModel().equalsIgnoreCase(model))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listData);
	}
}
