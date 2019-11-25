package co.com.tech.booking.bussiness.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingFlightResponse<T> {

	private int code;
	private String description;
	private T detail;
}
