package co.com.tech.booking.bussiness.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tech.booking.bussiness.BookingFlightService;
import co.com.tech.booking.bussiness.dto.BookingFlightResponse;
import co.com.tech.booking.bussiness.dto.BookingSearchRequest;
import co.com.tech.booking.bussiness.dto.FlightAvailable;
import co.com.tech.booking.bussiness.dto.ReservationDto;
import co.com.tech.booking.persistence.model.Flight;
import co.com.tech.booking.persistence.model.Reservation;
import co.com.tech.booking.persistence.repositories.FlightRepository;
import co.com.tech.booking.persistence.repositories.ReservationRepository;
import co.com.tech.booking.utils.BookingConstants;
import co.com.tech.booking.utils.BookingFlightMapper;

@Service
public class BookingFlightServiceImpl implements BookingFlightService{
	
	private static final String DATA_NOT_FOUND = "Data not found";
	private static final String SUCCESS_MSG = "Operation success";

	@Autowired
	private ReservationRepository reservartionRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public BookingFlightResponse<FlightAvailable> getFlights(BookingSearchRequest request) {
		BookingFlightResponse<FlightAvailable> response = new BookingFlightResponse<>();
		final FlightAvailable flightAvailable = new FlightAvailable();
		
		Date endDate = setFinalTimeDate(request.getInitDate());
		List<Flight> flightsOneWay = flightRepository.findByInitDateBetweenAndSourceAndDestiny(
				request.getInitDate(), endDate, request.getSource(), request.getDestiny());
		
		if(flightsOneWay.isEmpty()) {
			response.setCode(1);
			response.setDescription(DATA_NOT_FOUND);
			return response;
		}

		flightsOneWay.forEach(f -> flightAvailable.getFlightsOneWay().add(BookingFlightMapper.toFlightDto(f)));
		
		if(!request.isOneWay()) {
			endDate = setFinalTimeDate(request.getEndDate());
			List<Flight> flightsReturn = flightRepository.findByInitDateBetweenAndSourceAndDestiny(
					request.getEndDate(), endDate, request.getDestiny(), request.getSource());
			flightsReturn.forEach(f -> flightAvailable.getFlightsReturn().add(BookingFlightMapper.toFlightDto(f)));
		} 
		
		response.setDescription(SUCCESS_MSG);
		response.setDetail(flightAvailable);
		
		return response;
	}

	@Override
	public BookingFlightResponse<List<ReservationDto>> getReservations(String document) {
		BookingFlightResponse<List<ReservationDto>> response = new BookingFlightResponse<>();
		List<Reservation> reservations = reservartionRepository.findByDocumentOrderByDateDesc(document);
		
		if(reservations.isEmpty()) {
			response.setCode(1);
			response.setDescription(DATA_NOT_FOUND);
			return response;
		}
		
		List<ReservationDto> reservationDtos = new ArrayList<>();
		reservations.forEach(r -> reservationDtos.add(BookingFlightMapper.toReservationtDto(r)));
		response.setDescription(SUCCESS_MSG);
		response.setDetail(reservationDtos);
		
		return response;
	}

	@Override
	public BookingFlightResponse<String> createReservation(ReservationDto request) {
		BookingFlightResponse<String> response = new BookingFlightResponse<>();
		response.setDescription(SUCCESS_MSG);
		
		final Reservation reservation = BookingFlightMapper.toReservationEntity(request);
		reservartionRepository.save(reservation);
		return response;
	}
	
	private Date setFinalTimeDate(final Date date) {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(Calendar.HOUR_OF_DAY, BookingConstants.MAX_HOUR);
		gc.set(Calendar.MINUTE, BookingConstants.MAX_MIN_OR_SEC);
		gc.set(Calendar.SECOND, BookingConstants.MAX_MIN_OR_SEC);
		gc.set(Calendar.MILLISECOND, BookingConstants.MAX_MILLISECOND);
		return gc.getTime();
	}

}
