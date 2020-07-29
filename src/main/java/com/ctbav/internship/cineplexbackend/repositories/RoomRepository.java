package com.ctbav.internship.cineplexbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ctbav.internship.cineplexbackend.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
  Room findByRoomName(String room);

}
