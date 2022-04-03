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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement
@Entity
@Table(name = "FLIGHTS_DETAILS")
public class Flight {
	@Id
	@GeneratedValue
	@Column(name = "flight_Id")
	private Integer flightId;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "flight")
	private List<FlightSchedule> scheduleList;

	private String flightModel;
	private String carrierName;
	private Integer seatCap;
	private String sourceCity;
	private String destinationCity;
	
	
	
	public List<FlightSchedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<FlightSchedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	// Default Constructor
	public Flight() {
		super();
	}

	
	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Integer getSeatCap() {
		return seatCap;
	}

	public void setSeatCap(Integer seatCap) {
		this.seatCap = seatCap;
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

}
