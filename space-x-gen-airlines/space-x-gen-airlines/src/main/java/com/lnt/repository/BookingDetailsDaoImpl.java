package com.lnt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lnt.domain.BookingDetails;
import com.lnt.domain.FlightSchedule;

@Repository
public class BookingDetailsDaoImpl implements BookingDetailsDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<BookingDetails> searchAllBookings() {
		// TODO Auto-generated method stub
		return em.createQuery("select b from BookingDetails b", BookingDetails.class).getResultList();
	}

	@Override
	public List<BookingDetails> searchBookingByDate(String bookingDate) {
		// TODO Auto-generated method stub
		String jpql = "select b from BookingDetails b where b.bookingDate=?1";
		Query q = em.createQuery(jpql, BookingDetails.class);
		q.setParameter(1, bookingDate);
		return q.getResultList();
	}

	@Override
	public void addNewBooking(BookingDetails b) {
		// TODO Auto-generated method stub
		em.persist(b);
		b.setTotalFares(b.getTicketCost()*b.getNoOfPassenger());
		b.setStatus("confirmed");
		
	}

	@Override
	public void cancelBooking(BookingDetails b, int bookingId) {
		// TODO Auto-generated method stub
		String jpql="UPDATE BookingDetails SET b.status=?1 where b.bookingId=?2";
		Query q=em.createQuery(jpql, BookingDetails.class);
		q.setParameter(1, b.getStatus());
		q.setParameter(2, bookingId);
		q.executeUpdate();
		b.setStatus("cancelled");
		System.out.println("Booking cancelled for"+b.getBookingId());
		
		
		
	}
	
	
	

}
