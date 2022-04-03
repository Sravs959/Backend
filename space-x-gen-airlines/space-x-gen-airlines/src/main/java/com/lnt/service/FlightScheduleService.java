package com.lnt.service;

import java.util.List;

import com.lnt.domain.Flight;
import com.lnt.domain.FlightSchedule;

public interface FlightScheduleService {
	
		List<FlightSchedule> getAllSchedules();
		
		Flight getFlightById(int id);
		
		List<FlightSchedule> getScheduleByDateAndCity(String date, String sourceCity, String destinationCity);
		
		FlightSchedule getFlightScheduleByTripCode(int tripCode);
		
		void addNewScheduleService(FlightSchedule fs);
		
		void updateFlightScheduleService(Flight f, int id);
		
		void deleteFlightScheduleService(Flight f, int id);

		void updateSeats(Integer noOfPassenger, int tripCode);
		
}
