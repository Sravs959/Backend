package com.lnt.service;

import java.util.List;

import com.lnt.domain.Flight;

public interface FlightService {

	List<Flight> getAllFlightService();

	List<Flight> getFlightService(String sourceCity, String destinationCity);

	void addFlightService(Flight f);

	Flight searchFlightByIdService(int id);

	void updateFlightService(Flight f, int id);
}
