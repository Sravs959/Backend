package com.lnt.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
@Entity
@Table(name = "BOOKING_DETAILS")
public class BookingDetails {
	@Id
	@GeneratedValue
	@Column(name = "Booking_Id")
	private Integer bookingId;

	// @JsonFormat(pattern="yyyy-MM-dd")
	private String bookingDate;
	
	private Integer noOfPassenger;
	
	private String status;
	
	private Float totalFares;
	
	private Float ticketCost;
	
	
	
	
	public Float getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Float ticketCost) {
		this.ticketCost = ticketCost;
	}



	@ManyToOne
	private FlightSchedule flightSchedule;
	
	
	
	
	public Float getTotalFares() {
		return totalFares;
	}

	public void setTotalFares(Float totalFares) {
		this.totalFares = totalFares;
	}

	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}

	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	
	

	

	public BookingDetails(String bookingDate, Float ticketCost,
			String ticketType, Integer noOfPassenger, String status, FlightSchedule flightSchedule) {
		super();
		this.bookingDate = bookingDate;
		
		
		this.noOfPassenger = noOfPassenger;
		this.status = "notConfirmed";
		this.flightSchedule = flightSchedule;
	}

	public Integer getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(Integer noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	

	


	

	public BookingDetails() {
		super();
	}

}
