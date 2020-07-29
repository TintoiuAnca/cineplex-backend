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
public class Schedule  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;

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

	public Schedule(Long id, Date startTime, Date endTime, Date date, Movie scheduledMovie, Room room) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.scheduledMovie = scheduledMovie;
		this.room = room;
	}

	public Schedule(ScheduleDTO scheduleDto) throws ParseException {
		setDate(scheduleDto.getDate());
		setStartTime(scheduleDto.getStartTime());
		setEndTime(scheduleDto.getEndTime());
		setRoom(scheduleDto.getRoom());
		setScheduledMovie(scheduleDto.getScheduledMovie());
	}

	public Schedule() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
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

	@Temporal(TemporalType.TIMESTAMP)
	public void setEndTime(Date endTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(endTime);
		Date date = formatter.parse(strDate);
		this.endTime = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	public Date getEndTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(endTime);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(date);
		Date date = formatter.parse(strDate);
		return date;
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
		return "Schedule [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date
				+ ", scheduledMovie=" + scheduledMovie + ", room=" + room + ", tickets=" + tickets + "]";
	}

}
