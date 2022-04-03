package com.lnt.service;

import java.util.List;

import com.lnt.domain.BookingDetails;
import com.lnt.dto.BookingDTO;

public interface BookingDetailsService {

	List<BookingDetails> getAllBookingService();

	List<BookingDetails> getBookingByDateService(String date);

	void addBookingService(BookingDetails b, BookingDTO bd);

	void cancelBooking(BookingDetails b,int id);

}
