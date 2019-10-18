package com.ctbav.internship.cineplexbackend.DTO;

import java.text.ParseException;
import java.util.Date;
import com.ctbav.internship.cineplexbackend.models.History;
import com.ctbav.internship.cineplexbackend.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class HistoryDTO {
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expirationDate;
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public HistoryDTO(Long id, Date expirationDate, User user) {
		super();
		this.id = id;
		this.expirationDate = expirationDate;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HistoryDTO() {
		super();
	}

	public HistoryDTO(History history) throws ParseException {
		setId(history.getId());
		setExpirationDate(history.getExpirationDate());
		setUser(history.getUser());
	}

	@Override
	public String toString() {
		return "HistoryDTO [id=" + id + ", expirationDate=" + expirationDate + ", user=" + user + "]";
	}

}
