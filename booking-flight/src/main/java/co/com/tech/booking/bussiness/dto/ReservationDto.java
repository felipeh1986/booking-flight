package co.com.tech.booking.bussiness.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationDto {

	private Integer id;
	private String code;
	private Date date;
	private String document;
	private String lastName;
	private String firstName;
	private Date birthDate;
	private List<FlightDto> flights;
	
	
	public List<FlightDto> getFlights() {
		if(flights == null) {
			flights = new ArrayList<>();
		}
		return flights;
	}
	
	
}
