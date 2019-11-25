package co.com.tech.booking.bussiness.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.tech.booking.bussiness.BookingFlightService;
import co.com.tech.booking.bussiness.dto.BookingFlightResponse;
import co.com.tech.booking.bussiness.dto.BookingSearchRequest;
import co.com.tech.booking.bussiness.dto.FlightAvailable;
import co.com.tech.booking.bussiness.dto.ReservationDto;

@RestController
@ComponentScan("co.com.tech.booking.persistence")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BookingFlightController {
	
	private static final Logger LOGGER = Logger.getLogger(BookingFlightController.class);
	
	@Autowired
	private BookingFlightService bookingService;

	@RequestMapping(method = RequestMethod.POST, path="/booking/flight/getFlights")
	public ResponseEntity<BookingFlightResponse<FlightAvailable>> getFlights(@RequestBody BookingSearchRequest request) {
		
		LOGGER.info("********** getFlights ************");
		
		BookingFlightResponse<FlightAvailable> bodyResponse = bookingService.getFlights(request);
		return new ResponseEntity<BookingFlightResponse<FlightAvailable>>(bodyResponse, HttpStatus.OK);
	}
	
	@GetMapping("/booking/flight/getReservations/{document}")
	public ResponseEntity<BookingFlightResponse<List<ReservationDto>>> getReservations(
			@PathVariable String document) {
		
		LOGGER.info("********** getReservations ************ ");
		BookingFlightResponse<List<ReservationDto>> bodyResponse = bookingService.getReservations(document);
		return new ResponseEntity<BookingFlightResponse<List<ReservationDto>>>(bodyResponse, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path="/booking/flight/createReservation")
	public ResponseEntity<BookingFlightResponse<String>> createReservation(@RequestBody ReservationDto request) {
		LOGGER.info("********** createReservation ************ ");
		BookingFlightResponse<String> responseBody = bookingService.createReservation(request);
		return new ResponseEntity<BookingFlightResponse<String>>(responseBody, HttpStatus.OK);
	}
	
}
