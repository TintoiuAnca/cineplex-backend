package com.ctbav.internship.cineplexbackend.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ctbav.internship.cineplexbackend.DTO.RoomDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String roomName;
	private int nrRow;
	private int nrSeat;

	@OneToMany(mappedBy = "room")
	@JsonIgnore
	private List<Schedule> roomSchedules;

	@OneToMany(mappedBy = "rooms")
	@JsonIgnore
	private List<Seat> seats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getNrRow() {
		return nrRow;
	}

	public void setNrRow(int nrRow) {
		this.nrRow = nrRow;
	}

	public int getNrSeat() {
		return nrSeat;
	}

	public void setNrSeat(int nrSeat) {
		this.nrSeat = nrSeat;
	}

	public Room(RoomDTO roomDto) {
		setNrRow(roomDto.getNrRow());
		setNrSeat(roomDto.getNrSeat());
		setRoomName(roomDto.getRoomName());
	}

	public Room(Long id, String roomName, int nrRow, int nrSeat) {
		this.id = id;
		this.roomName = roomName;
		this.nrRow = nrRow;
		this.nrSeat = nrSeat;
	}

	public Room() {
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", nrRow=" + nrRow + ", nrSeat=" + nrSeat + "]";
	}

}
