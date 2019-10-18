package com.ctbav.internship.cineplexbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
	
}
