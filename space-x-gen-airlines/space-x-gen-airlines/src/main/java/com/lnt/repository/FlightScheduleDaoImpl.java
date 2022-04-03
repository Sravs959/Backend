package com.lnt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lnt.domain.BookingDetails;
import com.lnt.domain.Flight;
import com.lnt.domain.FlightSchedule;

@Repository
public class FlightScheduleDaoImpl implements FlightScheduleDao {
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<FlightSchedule> searchAllSchedules() {
		// TODO Auto-generated method stub
		return em.createQuery("select fs from FlightSchedule fs",FlightSchedule.class).getResultList();
	}

	@Override
	public List<FlightSchedule> searchScheduleByDateAndCity(String date, String sourceCity, String destinationCity) {
		// TODO Auto-generated method stub
		String jpql="select fs from FlightSchedule fs where fs.date=?1 AND fs.sourceCity=?2 AND fs.destinationCity=?3";
		Query q=em.createQuery(jpql,FlightSchedule.class);
		q.setParameter(1, date);
		q.setParameter(2, sourceCity);
		q.setParameter(3, destinationCity);
		return q.getResultList();
	}

	@Override
	public void addNewSchedule(FlightSchedule fs) {
		// TODO Auto-generated method stub
		em.persist(fs);
	}

	@Override
	public void updateFlightSchedule(Flight f, int id) {
		// TODO Auto-generated method stub
		Flight managedCopy=searchFlightById(id);
		managedCopy.setScheduleList(f.getScheduleList());
		System.out.println("Updated!!");
	}

	@Override
	public void deleteFlightSchedule(Flight f, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flight searchFlightById(int id) {
		// TODO Auto-generated method stub
		return em.find(Flight.class,id);
	}

	@Override
	public void updateSeats(Integer noOfPassenger, int tripCode) {
		String jpql="UPDATE FlightSchedule fs SET fs.seatsAvailable=(fs.seatsAvailable+?1) where fs.tripCode=?2";
		Query q=em.createQuery(jpql);
		q.setParameter(1, noOfPassenger);
		q.setParameter(2, tripCode);
		q.executeUpdate();
		System.out.println("Seats increased successfully with"+noOfPassenger);
	}

	@Override
	public FlightSchedule searchFlightScheduleByTripCode(int tripCode) {
		return em.find(FlightSchedule.class, tripCode);
	}

}
