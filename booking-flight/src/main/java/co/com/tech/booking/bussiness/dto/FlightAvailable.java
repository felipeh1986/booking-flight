package co.com.tech.booking.bussiness.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

@Setter
public class FlightAvailable {

	private List<FlightDto> flightsOneWay;
	private List<FlightDto> flightsReturn;
	
	public List<FlightDto> getFlightsOneWay() {
		if(flightsOneWay == null) {
			flightsOneWay = new ArrayList<>();
		}
		return flightsOneWay;
	}
	public List<FlightDto> getFlightsReturn() {
		if(flightsReturn == null) {
			flightsReturn = new ArrayList<>();
		}
		return flightsReturn;
	}
	
	
}
