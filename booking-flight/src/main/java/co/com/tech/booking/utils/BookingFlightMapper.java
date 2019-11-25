package co.com.tech.booking.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import co.com.tech.booking.bussiness.dto.FlightDto;
import co.com.tech.booking.bussiness.dto.ReservationDto;
import co.com.tech.booking.persistence.model.Flight;
import co.com.tech.booking.persistence.model.Reservation;

public final class BookingFlightMapper {

	public static final FlightDto toFlightDto(final Flight flight) {
		final FlightDto dto = new FlightDto();
		dto.setId(flight.getId());
		dto.setCode(flight.getCode());
		dto.setInitDate(flight.getInitDate());
		dto.setEndDate(flight.getEndDate());
		dto.setSource(flight.getSource());
		dto.setDestiny(flight.getDestiny());
		dto.setPrice(generatePrice(flight.getInitDate(), flight.getPrice()));
		
		return dto;
	}
	
	private static int generatePrice(final Date date, final Integer price) {
		Integer finalPrice = price;
		final GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		
		if(calendar.get(Calendar.AM) == Calendar.AM) {
			finalPrice = (int) (price * 1.10);
		}
		
		if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			finalPrice = (int) (price * 1.20);
		}
		
		return finalPrice;
	}
	
	public static final Flight toFlightEntity(final FlightDto dto) {
		final Flight flight = new Flight();
		flight.setId(dto.getId());
		flight.setCode(dto.getCode());
		flight.setInitDate(dto.getInitDate());
		flight.setEndDate(dto.getEndDate());
		flight.setSource(dto.getSource());
		flight.setDestiny(dto.getDestiny());
		flight.setPrice(dto.getPrice());
		
		return flight;
	}
	
	public static final ReservationDto toReservationtDto(final Reservation reservation) {
		final ReservationDto dto = new ReservationDto();
		dto.setId(reservation.getId());
		dto.setCode(reservation.getCode());
		dto.setDate(reservation.getDate());
		dto.setDocument(reservation.getDocument());
		dto.setFirstName(reservation.getFirstName());
		dto.setLastName(reservation.getLastName());
		dto.setBirthDate(reservation.getBirthDate());
		
		reservation.getFlights().forEach(f -> dto.getFlights().add(toFlightDto(f)));
		
		return dto;
	}
	
	public static final Reservation toReservationEntity(final ReservationDto dto) {
		final Reservation reservation = new Reservation();
		reservation.setId(dto.getId());
		reservation.setCode(dto.getCode());
		reservation.setDate(dto.getDate());
		reservation.setDocument(dto.getDocument());
		reservation.setFirstName(dto.getFirstName());
		reservation.setLastName(dto.getLastName());
		reservation.setBirthDate(dto.getBirthDate());
		
		dto.getFlights().forEach(f -> reservation.getFlights().add(toFlightEntity(f)));
		
		return reservation;
	}
	
	
}
