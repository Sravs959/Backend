package com.lnt.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity //Used to make entity class. It enables persistence in DB (used to make tables)
@Table(name = "USER_DETAILS") //
public class UserDetails {

	@Id //Primary key
	@GeneratedValue //Auto generated value
	@Column(name = "user_Id") //for column names 
	private Integer userId;

	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String password;
	private String phoneNo;
	private String email;
	
	@OneToMany //One user can book many tickets
	private List<BookingDetails> bookingList;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserDetails() {
		super();
	}

	public UserDetails(String firstName, String lastName, String dateOfBirth, String password, String cPassword,
			String phoneNo, String email, List<BookingDetails> bookingList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.phoneNo = phoneNo;
		this.email = email;
		this.bookingList = bookingList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBith() {
		return dateOfBirth;
	}

	public void setDateOfBith(String dateOfBith) {
		this.dateOfBirth = dateOfBith;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BookingDetails> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingDetails> bookingList) {
		this.bookingList = bookingList;
	}

}
