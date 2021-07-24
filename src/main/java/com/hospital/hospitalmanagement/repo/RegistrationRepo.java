package com.hospital.hospitalmanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.hospitalmanagement.dao.Login;

@Repository
public interface RegistrationRepo extends JpaRepository<Login, Integer> {
	Optional<Login> findByEmail(String emailid);
}
