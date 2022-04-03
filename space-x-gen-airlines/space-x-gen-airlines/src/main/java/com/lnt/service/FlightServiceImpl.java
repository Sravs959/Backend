package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.domain.Flight;
import com.lnt.repository.FlightDao;

@Transactional

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;

	@Override
	public List<Flight> getAllFlightService() {
		// TODO Auto-generated method stub
		return flightDao.searchAllFlights();
	}

	@Override
	public void addFlightService(Flight f) {
		// TODO Auto-generated method stub
		flightDao.addNewFlight(f);

	}

	@Override
	public Flight searchFlightByIdService(int id) {
		// TODO Auto-generated method stub
		Flight f = flightDao.searchFlightById(id);
		if (f == null) {
			String msg = "The flight" + id + "not found";
			// throw exception(msg);
		}
		return f;
	}

	@Override
	public void updateFlightService(Flight f, int id) {
		// TODO Auto-generated method stub
		flightDao.updateFlight(f, id);

	}

	@Override
	public List<Flight> getFlightService(String sourceCity, String destinationCity) {
		// TODO Auto-generated method stub
		return flightDao.searchFlights(sourceCity, destinationCity);
	}

}
