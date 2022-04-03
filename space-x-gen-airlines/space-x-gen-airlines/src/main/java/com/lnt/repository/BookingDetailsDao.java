package com.lnt.repository;

import java.util.List;

import com.lnt.domain.BookingDetails;

public interface BookingDetailsDao {

	List<BookingDetails> searchAllBookings();

	List<BookingDetails> searchBookingByDate(String bookingDate);

	void addNewBooking(BookingDetails b);
	
	void cancelBooking(BookingDetails b, int bookingId);

}
