package com.ctbav.internship.cineplexbackend.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.ctbav.internship.cineplexbackend.DTO.ScheduleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date hour;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "scheduledMovie", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Movie scheduledMovie;

	@ManyToOne
	@JoinColumn(name = "room", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Room room;

	@OneToMany(mappedBy = "schedule")
	@JsonIgnore
	private List<Ticket> tickets;

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", hour=" + hour + ", date=" + date + ", scheduledMovie=" + scheduledMovie
				+ ", room=" + room + "]";
	}

	public Schedule(Long id, Date hour, Date date, Movie scheduledMovie, Room room) {
		super();
		this.id = id;
		this.hour = hour;
		this.date = date;
		this.scheduledMovie = scheduledMovie;
		this.room = room;
	}

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

	public Schedule() {
		super();
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
		Date date = formatter.parse(strDate);
		return date;
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

	public Schedule(ScheduleDTO scheduleDto) throws ParseException {
		setDate(scheduleDto.getDate());
		setHour(scheduleDto.getHour());
		setRoom(scheduleDto.getRoom());
		setScheduledMovie(scheduleDto.getScheduledMovie());
	}
}
