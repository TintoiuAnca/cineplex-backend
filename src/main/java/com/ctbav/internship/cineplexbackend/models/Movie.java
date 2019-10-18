package com.ctbav.internship.cineplexbackend.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.ctbav.internship.cineplexbackend.DTO.MovieDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String format;
	private String name;
	private String gendre;
	private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date time;

	private int ageRecommandation;
	private String distribution;
	private String director;
	private double rating;
	private String video;
	private String image;

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cinemaDate;

	@OneToMany(mappedBy = "movies")
	@JsonIgnore
	private List<Seat> seats;

	@OneToMany(mappedBy = "scheduledMovie", fetch = FetchType.EAGER)
	@JsonInclude(Include.NON_NULL)
	private List<Schedule> movieSchedules;



	@OneToMany(mappedBy = "movieName")
	@JsonIgnore
	private List<Statistic> statistics;

	public Movie(Long id, String format, String name, String gendre, String description, Date time,
			int ageRecommandation, String distribution, String director, double rating, Date cinemaDate,String video,String image) {
		super();
		this.id = id;
		this.format = format;
		this.name = name;
		this.gendre = gendre;
		this.description = description;
		this.time = time;
		this.ageRecommandation = ageRecommandation;
		this.distribution = distribution;
		this.director = director;
		this.rating = rating;
		this.cinemaDate = cinemaDate;
		this.video=video;
		this.image=image;


	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Schedule> getMovieSchedules() {
		return movieSchedules;
	}

	public void setMovieSchedules(List<Schedule> movieSchedules) {
		this.movieSchedules = movieSchedules;
	}

	public Movie(MovieDTO entity) throws ParseException {
		setName(entity.getName());
		setId(entity.getId());
		setAgeRecommandation(entity.getAgeRecommandation());
		setCinemaDate(entity.getCinemaDate());
		setDescription(entity.getDescription());
		setDirector(entity.getDirector());
		setDistribution(entity.getDistribution());
		setFormat(entity.getFormat());
		setGendre(entity.getGendre());
		setRating(entity.getRating());
		setTime(entity.getTime());
		setVideo(entity.getVideo());
		setImage(entity.getImage());
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(time);
		Date time = formatter.parse(strDate);
		return time;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTime(Date time) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(time);
		Date date = formatter.parse(strDate);
		this.time = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCinemaDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(cinemaDate);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setCinemaDate(Date cinemaDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(cinemaDate);
		Date date = formatter.parse(strDate);
		this.cinemaDate = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGendre() {
		return gendre;
	}

	public void setGendre(String gendre) {
		this.gendre = gendre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAgeRecommandation() {
		return ageRecommandation;
	}

	public void setAgeRecommandation(int ageRecommandation) {
		this.ageRecommandation = ageRecommandation;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Statistic> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<Statistic> statistics) {
		this.statistics = statistics;
	}

	public Movie() {
		super();
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", format=" + format + ", name=" + name + ", gendre=" + gendre + ", description="
				+ description + ", time=" + time + ", ageRecommandation=" + ageRecommandation + ", distribution="
				+ distribution + ", director=" + director + ", rating=" + rating + ", video=" + video + ", image="
				+ image + ", cinemaDate=" + cinemaDate + ", movieSchedules=" + movieSchedules + "]";
	}

	

	
}
