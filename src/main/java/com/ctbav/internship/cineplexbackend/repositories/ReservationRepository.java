package com.ctbav.internship.cineplexbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
}
