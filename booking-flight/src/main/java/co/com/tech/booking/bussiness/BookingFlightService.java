package co.com.tech.booking.bussiness;

import java.util.List;

import co.com.tech.booking.bussiness.dto.BookingFlightResponse;
import co.com.tech.booking.bussiness.dto.BookingSearchRequest;
import co.com.tech.booking.bussiness.dto.FlightAvailable;
import co.com.tech.booking.bussiness.dto.ReservationDto;

public interface BookingFlightService {

	BookingFlightResponse<FlightAvailable> getFlights(BookingSearchRequest request);
	
	BookingFlightResponse<List<ReservationDto>> getReservations(String document);
	
	BookingFlightResponse<String> createReservation(ReservationDto request);
}
