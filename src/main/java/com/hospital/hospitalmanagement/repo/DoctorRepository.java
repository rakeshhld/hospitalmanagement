package com.hospital.hospitalmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmanagement.dao.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	List<Doctor> findAllBySpecialization(String specialization);
}
