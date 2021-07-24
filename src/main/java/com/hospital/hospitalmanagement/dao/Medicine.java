package com.hospital.hospitalmanagement.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Medicine {
	@Id
	@Column(name = "medicine_id")
	private int medicineId;
	private String medicineName;
	private String medicineType;
	private boolean isMorning;
	private boolean isAfterNoon;
	private boolean isNight;
	private int qty;
	private boolean isAfterMeal;

}
