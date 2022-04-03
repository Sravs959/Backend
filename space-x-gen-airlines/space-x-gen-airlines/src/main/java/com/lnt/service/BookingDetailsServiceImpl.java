package com.lnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.domain.BookingDetails;
import com.lnt.domain.FlightSchedule;
import com.lnt.dto.BookingDTO;
import com.lnt.repository.BookingDetailsDao;
import com.lnt.repository.FlightScheduleDao;

@Transactional

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsDao bookingDao;
	
	
	@Autowired
	private FlightScheduleDao flightSchedule;
	

	@Override
	public List<BookingDetails> getAllBookingService() {
		// TODO Auto-generated method stub
		return bookingDao.searchAllBookings();
	}

	@Override
	public List<BookingDetails> getBookingByDateService(String date) {
		// TODO Auto-generated method stub
		return bookingDao.searchBookingByDate(date);
	}

	@Override
	public void addBookingService(BookingDetails b, BookingDTO bd) {
		FlightSchedule fs=flightSchedule.searchFlightScheduleByTripCode(bd.getTripCode());
		b.setFlightSchedule(fs);
		bookingDao.addNewBooking(b);
		System.out.println("Added "+b);
		flightSchedule.updateSeats(0-(b.getNoOfPassenger()), (b.getFlightSchedule().getTripCode()));

	}

	@Override
	public void cancelBooking(BookingDetails b, int id) {
		// TODO Auto-generated method stub
		bookingDao.cancelBooking(b, id);
		b.setStatus("Cancelled");
		flightSchedule.updateSeats(b.getNoOfPassenger(),b.getFlightSchedule().getTripCode());
		
		
	}

	
}
