package com.ctbav.internship.cineplexbackend.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Statistic;
import com.fasterxml.jackson.annotation.JsonFormat;

public class StatisticDTO {
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date generationTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date generationDate;
	private String document;
	private Movie movieName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getGenerationTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(generationTime);
		Date date = formatter.parse(strDate);
		System.out.println(date);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setGenerationTime(Date generationTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(generationTime);
		Date date = formatter.parse(strDate);
		System.out.println(date);
		this.generationTime = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getGenerationDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(generationDate);
		Date date = formatter.parse(strDate);
		System.out.println(date);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setGenerationDate(Date generationDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(generationDate);
		Date date = formatter.parse(strDate);
		System.out.println(date);
		this.generationDate = date;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Movie getMovieName() {
		return movieName;
	}

	public void setMovieName(Movie movieName) {
		this.movieName = movieName;
	}

	@Override
	public String toString() {
		return "StatisticDTO [id=" + id + ", generationTime=" + generationTime + ", generationDate=" + generationDate
				+ ", document=" + document + ", movieName=" + movieName + "]";
	}

	public StatisticDTO(Long id, Date generationTime, Date generationDate, String document, Movie movieName) {
		this.id = id;
		this.generationTime = generationTime;
		this.generationDate = generationDate;
		this.document = document;
		this.movieName = movieName;
	}

	public StatisticDTO() {
	}

	public StatisticDTO(Statistic statistic) throws ParseException {
		setGenerationDate(statistic.getGenerationDate());
		setGenerationTime(statistic.getGenerationTime());
		setDocument(statistic.getDocument());
		setMovieName(statistic.getMovieName());
	}

}
