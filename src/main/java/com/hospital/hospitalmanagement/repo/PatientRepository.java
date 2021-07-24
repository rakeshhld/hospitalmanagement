package com.hospital.hospitalmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmanagement.dao.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
