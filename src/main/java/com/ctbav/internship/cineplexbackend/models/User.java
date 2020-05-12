package com.ctbav.internship.cineplexbackend.models;

import java.io.Serializable;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ctbav.internship.cineplexbackend.DTO.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userName;

	private String mail;

	private String phoneNumber;

	private String address;

	private String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateBirth;

	@ManyToOne
	@JoinColumn(name = "userType", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserType userType;

	@OneToMany(mappedBy = "payer")
	@JsonIgnore
	private List<Payment> payments;

	@OneToMany(mappedBy = "userRes")
	@JsonIgnore
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<History> history;

	public User() {

	}

	public User(String userType) {
		this.userType = new UserType(userType);
	}

	public User(UserDTO userDto) throws ParseException {
		setUserName(userDto.getUserName());
		setAddress(userDto.getAddress());
		setDateBirth(userDto.getDateBirth());
		setMail(userDto.getMail());
		setPhoneNumber(userDto.getPhoneNumber());
		setPassword(userDto.getPassword());

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
	     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    this.password = passwordEncoder.encode(password);
	}

	@Temporal(TemporalType.DATE)
	public Date getDateBirth() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(dateBirth);
		Date date = formatter.parse(strDate);
		return date;
	}

	@Temporal(TemporalType.DATE)
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

	public User(Long id, String userName, String mail, String phoneNumber, String address, Date dateBirth,
			UserType userType, String password) {
		this.id = id;
		this.userName = userName;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateBirth = dateBirth;
		this.userType = userType;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", mail=" + mail + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", password=" + password + ", dateBirth=" + dateBirth + ", userType="
				+ userType + "]";
	}

}
