package com.ctbav.internship.cineplexbackend.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.ctbav.internship.cineplexbackend.DTO.StatisticDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Statistic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date generationTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date generationDate;
	private String document;

	@ManyToOne
	@JoinColumn(name = "movieName", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
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

	public Date getGenerationDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(generationDate);
		Date date = formatter.parse(strDate);
		System.out.println(date);
		return date;
	}

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

	public Statistic() {
	}

	@Override
	public String toString() {
		return "Statistic [id=" + id + ", generationTime=" + generationTime + ", generationDate=" + generationDate
				+ ", document=" + document + ", movieName=" + movieName + "]";
	}

	public Statistic(Long id, Date generationTime, Date generationDate, String document, Movie movieName) {
		super();
		this.id = id;
		this.generationTime = generationTime;
		this.generationDate = generationDate;
		this.document = document;
		this.movieName = movieName;
	}

	public Statistic(StatisticDTO statisticDto) throws ParseException {
		setGenerationDate(statisticDto.getGenerationDate());
		setGenerationTime(statisticDto.getGenerationTime());
		setDocument(statisticDto.getDocument());
		setMovieName(statisticDto.getMovieName());

	}

}
