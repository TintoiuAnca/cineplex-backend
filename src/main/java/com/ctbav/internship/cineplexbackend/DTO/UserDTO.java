package com.ctbav.internship.cineplexbackend.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.ctbav.internship.cineplexbackend.models.User;
import com.ctbav.internship.cineplexbackend.models.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {

	private Long id;
	private String userName;
	private String mail;
	private String phoneNumber;
	private String address;
	private String password;
	private String confirmPassword;
	private UserType userType;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateBirth;

	public String getPassword() {
		return password;
	}

	public UserDTO(Long id, String userName, String mail, String phoneNumber, String address, String password,
			String confirmPassword, Date dateBirth, UserType userType) {
		super();
		this.id = id;
		this.userName = userName;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateBirth = dateBirth;
		this.userType = userType;
	}

	public UserDTO() {

	}

	public UserDTO(User user) throws ParseException {
		setUserName(user.getUserName());
		setAddress(user.getAddress());
		setDateBirth(user.getDateBirth());
		setMail(user.getMail());
		setPhoneNumber(user.getPhoneNumber());
		setPassword(user.getPassword());
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateBirth() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(dateBirth);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDateBirth(Date dateBirth) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(dateBirth);
		Date date = formatter.parse(strDate);
		this.dateBirth = date;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
