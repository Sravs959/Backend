package com.lnt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lnt.domain.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Flight> searchAllFlights() {
		// TODO Auto-generated method stub
		return em.createQuery("select f from Flight f", Flight.class).getResultList();
	}

	@Override
	public void addNewFlight(Flight f) {
		// TODO Auto-generated method stub
		em.persist(f);//save the flight details in DB.

	}

	@Override
	public Flight searchFlightById(int id) {
		// TODO Auto-generated method stub
		return em.find(Flight.class, id);// retrieve one data. 
	}

	@Override
	public void updateFlight(Flight f, int id) {
		// TODO Auto-generated method stub
		Flight managedCopy = searchFlightById(id);
		managedCopy.setCarrierName(f.getCarrierName());
		managedCopy.setDestinationCity(f.getDestinationCity());
		managedCopy.setFlightId(f.getFlightId());
		managedCopy.setFlightModel(f.getFlightModel());
		managedCopy.setSeatCap(f.getSeatCap());
		managedCopy.setSourceCity(f.getSourceCity());
		System.out.println("Updated!");

	}

	@Override
	public List<Flight> searchFlights(String sourceCity, String destinationCity) {
		// TODO Auto-generated method stub
		String jpql = "select f from Flight f where f.sourceCity=?1 AND f.destinationCity=?2";
		//Example of Parameterized Query. 
		Query q = em.createQuery(jpql, Flight.class);
		q.setParameter(1, sourceCity);
		q.setParameter(2, destinationCity);

		return q.getResultList();

	}

}
