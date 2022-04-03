package com.lnt.repository;

import java.util.List;

import com.lnt.domain.Flight;

public interface FlightDao {

	List<Flight> searchAllFlights();

	List<Flight> searchFlights(String sourceCity, String destinationCity);

	Flight searchFlightById(int id);

	void updateFlight(Flight f, int id);

	void addNewFlight(Flight f);

}
