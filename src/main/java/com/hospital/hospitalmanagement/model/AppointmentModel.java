package com.hospital.hospitalmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AppointmentModel {
	@JsonProperty("appointment_start_date")
	private String appointmentDate;
	@JsonProperty("appointment_end_date")
	private String appointmentEndDate;
}
