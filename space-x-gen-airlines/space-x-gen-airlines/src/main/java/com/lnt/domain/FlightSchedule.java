package com.lnt.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
@Entity
@Table(name = "FLIGHTS_SCHEDULE")
public class FlightSchedule {

	@Id
	@GeneratedValue
	private int tripCode;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER) //One to many bi-directional
	@JoinColumn(name = "flight_Id")
	private Flight flight;

	// @JsonFormat(pattern = "yyyy-MM-dd")
	private String date;

	// @JsonFormat(pattern = "hh-mm-ss")
	private String time;

	private String sourceCity;
	private String destinationCity;
	private Integer seatsAvailable;
	private Float ticketCost;
	private Float offers;
	
	

	public Float getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Float ticketCost) {
		this.ticketCost = ticketCost;
	}

	public FlightSchedule(Flight flight, String date, String time, String sourceCity, String destinationCity,
			Integer seatsAvailable, Float offers) {
		super();
		this.flight = flight;
		this.date = date;
		this.time = time;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.seatsAvailable = seatsAvailable;
		this.offers = offers;
	}

	public int getTripCode() {
		return tripCode;
	}

	public void setTripCode(int tripCode) {
		this.tripCode = tripCode;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Float getOffers() {
		return offers;
	}

	public void setOffers(Float offers) {
		this.offers = offers;
	}

	public FlightSchedule() {
		super();
	}

}
