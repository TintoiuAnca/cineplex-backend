package com.ctbav.internship.cineplexbackend.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
  private UserType userType;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date dateBirth;


  public UserDTO(Long id, String userName, String mail, String phoneNumber, String address,
      String password, Date dateBirth, UserType userType) {
    super();
    this.id = id;
    this.userName = userName;
    this.mail = mail;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.password = password;
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
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    this.password = passwordEncoder.encode(password);
  }

  public String getPassword() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
    User user=new User();
    boolean matchPassword=encoder.matches(password, user.getPassword()); 
    if(matchPassword)
       return password;
    else
      return "Could not get password";
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

}
