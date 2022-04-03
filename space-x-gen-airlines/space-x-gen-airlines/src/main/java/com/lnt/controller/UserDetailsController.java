package com.lnt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.domain.BookingDetails;
import com.lnt.domain.Flight;
import com.lnt.domain.FlightSchedule;
import com.lnt.domain.UserDetails;
import com.lnt.dto.BookingDTO;
import com.lnt.service.BookingDetailsService;
import com.lnt.service.FlightScheduleService;
import com.lnt.service.FlightService;
import com.lnt.service.UserDetailsService;
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}) //Cross Origin enables cross origin resource sharing only for specific method
@RestController //It allows the class to maintain or handle requests made by client
@RequestMapping("/users") //MApping the HTTP request to a method 
public class UserDetailsController {

	@Autowired //It can be used autowire beans on setter method
	private UserDetailsService userService;
	@Autowired
	private BookingDetailsService bookingService;
	@Autowired
	
	private FlightScheduleService fsService;
	@Autowired
	private FlightService flightService;

	HttpSession session;

	@PostMapping(value = "/login")
	public boolean login(@RequestBody UserDetails user) {

		
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		List<UserDetails> users = userService.getAllUserService();

		for (UserDetails u : users) {
			if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
				System.out.println("Logged IN!");
				return true;
			}
		}
		return false;

	}

	@RequestMapping("/all")
	public List<UserDetails> getAllUsers() {
		return userService.getAllUserService();
	}
	
	//API in users to access flight search.
	@RequestMapping(path = "/flight/find/{sourceCity}/{destinationCity}", method = RequestMethod.GET)
	public List<Flight> findFlightByCity(@PathVariable String sourceCity, @PathVariable String destinationCity) {
		return flightService.getFlightService(sourceCity, destinationCity);
	}

	@RequestMapping("/find/{id}")
	public UserDetails findUserById(@PathVariable int id) {
		return userService.searchUserByIdService(id);
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public void updateUserDetails(@RequestBody UserDetails u, @PathVariable int id) {
		userService.updateUserDetailsService(u, id);
	}

	@RequestMapping(path = "/booking", method = RequestMethod.POST, consumes="application/json")
	/*public void addANewBooking(@RequestBody BookingDetails b) {
		System.out.println("Booking successful!");
		bookingService.addBookingService(b);
	}*/
	public void addANewBooking(@RequestBody BookingDTO bd) {	
		FlightSchedule flightSchedule=fsService.getFlightScheduleByTripCode(bd.getTripCode());
		BookingDetails booking= new BookingDetails();
		booking.setStatus("confirmed");
		booking.setBookingDate(flightSchedule.getDate());
		booking.setNoOfPassenger(bd.getNoOfSeats());
		booking.setTicketCost(flightSchedule.getTicketCost());
		bookingService.addBookingService(booking,bd);
		System.out.println("Booking successful!");
	}


	@RequestMapping(path = "/booking/find/{bookingDate}", method = RequestMethod.GET)
	public List<BookingDetails> findBookingByDate(@PathVariable String bookingDate) {
		return bookingService.getBookingByDateService(bookingDate);
	}

	@RequestMapping(path = "/booking/update/{id}", method = RequestMethod.PUT)
	public void cancelBooking(@RequestBody BookingDetails b, @PathVariable int id) { //It takes variables as a parameter 
		System.out.println("Booking has been cancelled!"); 
		bookingService.cancelBooking(b, id);
	}

	@RequestMapping(path = "/flight-schedule/all", method = RequestMethod.GET)
	public List<FlightSchedule> getAllSchedules() {
		return fsService.getAllSchedules();
	}

	@RequestMapping(path = "/flight-schedule/find/{date}/{sourceCity}/{destinationCity}", method = RequestMethod.GET)
	public List<FlightSchedule> getFlightScheduleByDateAndCity(@PathVariable String date, @PathVariable String sourceCity, @PathVariable String destinationCity) {
		return fsService.getScheduleByDateAndCity(date, sourceCity, destinationCity);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	// @PostMapping
	public void addNewUser(@RequestBody UserDetails u) { //It takes class as a parameter 
		System.out.println(u.getFirstName());
		userService.addUserService(u);
	}
}
