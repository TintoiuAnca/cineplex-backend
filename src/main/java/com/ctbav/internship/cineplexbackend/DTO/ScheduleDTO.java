package com.ctbav.internship.cineplexbackend.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Room;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDTO {
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date hour;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	private Movie scheduledMovie;
	private Room room;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getHour() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(hour);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setHour(Date hour) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(hour);
		Date date = formatter.parse(strDate);
		this.hour = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(date);
		Date data = formatter.parse(strDate);
		return data;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDate(Date date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(date);
		Date data = formatter.parse(strDate);
		this.date = data;
	}

	public Movie getScheduledMovie() {
		return scheduledMovie;
	}

	public void setScheduledMovie(Movie scheduledMovie) {
		this.scheduledMovie = scheduledMovie;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public ScheduleDTO(Long id, Date hour, Date date, Movie scheduledMovie, Room room) {
		super();
		this.id = id;
		this.hour = hour;
		this.date = date;
		this.scheduledMovie = scheduledMovie;
		this.room = room;
	}

	public ScheduleDTO() {

	}

	public ScheduleDTO(Schedule schedule) throws ParseException {
		setDate(schedule.getDate());
		setHour(schedule.getHour());
		setRoom(schedule.getRoom());
		setScheduledMovie(schedule.getScheduledMovie());
	}
}
