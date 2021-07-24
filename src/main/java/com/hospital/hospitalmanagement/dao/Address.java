package com.hospital.hospitalmanagement.dao;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Address {
	private int houseNo;
	private String street;
	private String area;
	private String city;
	private String district;
	private String taluk;
	private int pinCode;
}
