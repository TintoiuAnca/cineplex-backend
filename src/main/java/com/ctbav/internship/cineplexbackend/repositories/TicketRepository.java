package com.ctbav.internship.cineplexbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
