package com.ctbav.internship.cineplexbackend.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Room;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDTO {
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	private Movie scheduledMovie;
	private Room room;

	public ScheduleDTO(Long id, Date startTime, Date endTime, Date date, Movie scheduledMovie, Room room) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.scheduledMovie = scheduledMovie;
		this.room = room;
	}

	public ScheduleDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(endTime);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setEndTime(Date endTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(endTime);
		Date date = formatter.parse(strDate);
		this.endTime = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(startTime);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setStartTime(Date startTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(startTime);
		Date date = formatter.parse(strDate);
		this.startTime = date;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(date);
		Date data = formatter.parse(strDate);
		return data;
	}

	@Temporal(TemporalType.DATE)
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

	@Override
	public String toString() {
		return "ScheduleDTO [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date
				+ ", scheduledMovie=" + scheduledMovie + ", room=" + room + "]";
	}

}
