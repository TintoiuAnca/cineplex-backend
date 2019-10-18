package com.ctbav.internship.cineplexbackend.DTO;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.ctbav.internship.cineplexbackend.models.Movie;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;

//@JsonDeserialize(using = MovieDeserializer.class)
public class MovieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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

	private List<Schedule> movieSchedules;

	public List<Schedule> getMovieSchedules() {
		return movieSchedules;
	}

	public void setMovieSchedules(List<Schedule> movieSchedules) {
		this.movieSchedules = movieSchedules;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date cinemaDate;

	public MovieDTO(Long id, String format, String name, String gendre, String description, Date time,
			int ageRecommandation, String distribution, String director, double rating, String video, String image,
			List<Schedule> movieSchedules, Date cinemaDate) {
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
		this.video = video;
		this.image = image;
		this.movieSchedules = movieSchedules;
		this.cinemaDate = cinemaDate;
		this.movieSchedules = movieSchedules;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(time);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTime(Date time) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(time);
		Date date = formatter.parse(strDate);
		this.time = date;
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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCinemaDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(cinemaDate);
		Date date = formatter.parse(strDate);
		System.out.println(date);
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

	public MovieDTO(Movie movie) throws ParseException {
		setName(movie.getName());
		setId(movie.getId());
		setAgeRecommandation(movie.getAgeRecommandation());
		setCinemaDate(movie.getCinemaDate());
		setDescription(movie.getDescription());
		setDirector(movie.getDirector());
		setDistribution(movie.getDistribution());
		setFormat(movie.getFormat());
		setGendre(movie.getGendre());
		setRating(movie.getRating());
		setTime(movie.getTime());
		setVideo(movie.getVideo());
		setImage(movie.getImage());

	}

	public MovieDTO() {

	}

	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", format=" + format + ", name=" + name + ", gendre=" + gendre + ", description="
				+ description + ", time=" + time + ", ageRecommandation=" + ageRecommandation + ", distribution="
				+ distribution + ", director=" + director + ", rating=" + rating + ", video=" + video + ", image="
				+ image + ", movieSchedules=" + movieSchedules + ", cinemaDate=" + cinemaDate + "]";
	}

}
