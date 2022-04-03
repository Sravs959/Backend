package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.domain.Flight;
import com.lnt.domain.FlightSchedule;
import com.lnt.repository.FlightDao;
import com.lnt.repository.FlightScheduleDao;

@Transactional
@Service
public class FlightScheduleServiceImpl implements FlightScheduleService{

	@Autowired
	private FlightScheduleDao fsDao;
	
	@Autowired
	private FlightDao fDao;
	
	@Override
	public List<FlightSchedule> getAllSchedules() {
		// TODO Auto-generated method stub
		return fsDao.searchAllSchedules();
	}

	@Override
	public Flight getFlightById(int id) {
		// TODO Auto-generated method stub
		Flight f=fsDao.searchFlightById(id);
		if(f==null) {
			//Exception msg
		}
		return f;
	}

	@Override
	public List<FlightSchedule> getScheduleByDateAndCity(String date, String sourceCity, String destinationCity) {
		// TODO Auto-generated method stub
		return fsDao.searchScheduleByDateAndCity(date, sourceCity, destinationCity);
	}

	@Override
	public void addNewScheduleService(FlightSchedule fs) {
		// TODO Auto-generated method stub
		Flight flight = fDao.searchFlightById(fs.getFlight().getFlightId());
		fs.setFlight(flight);
		fsDao.addNewSchedule(fs);
	}

	@Override
	public void updateFlightScheduleService(Flight f, int id) {
		// TODO Auto-generated method stub
		fsDao.updateFlightSchedule(f, id);
	}

	@Override
	public void deleteFlightScheduleService(Flight f, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSeats(Integer noOfPassenger, int tripCode) {
		fsDao.updateSeats(noOfPassenger, tripCode) ;
	}

	@Override
	public FlightSchedule getFlightScheduleByTripCode(int tripCode) {
		// TODO Auto-generated method stub
		return fsDao.searchFlightScheduleByTripCode(tripCode);
	}

}
