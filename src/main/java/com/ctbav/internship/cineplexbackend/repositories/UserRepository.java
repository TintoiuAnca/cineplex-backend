package com.ctbav.internship.cineplexbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
