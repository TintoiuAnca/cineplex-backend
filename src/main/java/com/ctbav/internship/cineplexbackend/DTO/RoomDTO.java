package com.ctbav.internship.cineplexbackend.DTO;

import com.ctbav.internship.cineplexbackend.models.Room;

public class RoomDTO {
	private Long id;
	private String roomName;
	private int nrRow;
	private int nrSeat;

	public RoomDTO() {
	}

	public RoomDTO(Long id, String roomName, int nrRow, int nrSeat) {
		this.id = id;
		this.roomName = roomName;
		this.nrRow = nrRow;
		this.nrSeat = nrSeat;
	}

	public RoomDTO(Room room) {
		setNrRow(room.getNrRow());
		setNrSeat(room.getNrSeat());
		setRoomName(room.getRoomName());
	}

	@Override
	public String toString() {
		return "RoomDTO [id=" + id + ", roomName=" + roomName + ", nrRow=" + nrRow + ", nrSeat=" + nrSeat + "]";
	}

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

}
