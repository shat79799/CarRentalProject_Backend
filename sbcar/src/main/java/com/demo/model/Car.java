package com.demo.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="car")
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private int seats;
	private int doors;
	private int luggage;
	private int cc;
	private String fuel;
	private int price;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "mileage_fee")

	private Double mileageFee;
}