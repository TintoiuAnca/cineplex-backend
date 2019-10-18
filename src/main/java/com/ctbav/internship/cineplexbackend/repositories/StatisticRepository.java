package com.ctbav.internship.cineplexbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic,Long> {

}
