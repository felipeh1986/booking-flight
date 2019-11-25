package co.com.tech.booking.bussiness.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.tech.booking.AbstractTest;
import co.com.tech.booking.bussiness.dto.BookingFlightResponse;
import co.com.tech.booking.bussiness.dto.BookingSearchRequest;
import co.com.tech.booking.bussiness.dto.ReservationDto;

public class BookingFlightControllerTest extends AbstractTest {

	@SuppressWarnings("unchecked")
	@Test
	public void getReservations_success() throws Exception {
		String uri = "/booking/flight/getReservations/1234567890";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		
		String content = mvcResult.getResponse().getContentAsString();
		
		BookingFlightResponse<List<ReservationDto>> response = super.mapFromJson(content, BookingFlightResponse.class);
		assertTrue(response != null);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getFlights_success() throws Exception {
		String uri = "/booking/flight/getFlights";
		final String request = super.mapToJson(createRequest());
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(request)).andReturn();
		
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		
		String content = mvcResult.getResponse().getContentAsString();
		
		BookingFlightResponse<List<ReservationDto>> response = super.mapFromJson(content, BookingFlightResponse.class);
		assertTrue(response.getCode() == 0);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void createReservation_success() throws Exception {
		String uri = "/booking/flight/createReservation";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(creteReservationRequest())).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);
		
		String content = mvcResult.getResponse().getContentAsString();
		
		BookingFlightResponse<List<ReservationDto>> response = super.mapFromJson(content, BookingFlightResponse.class);
		assertTrue(response.getCode() == 0);
	}
	
	private BookingSearchRequest createRequest() {
		final BookingSearchRequest request = new BookingSearchRequest();
		request.setSource("Medellin");
		request.setDestiny("Bogota");
		request.setInitDate(new Date(1574658000000L));
		request.setEndDate(new Date(1574744400000L));
		request.setOneWay(false);
		
		return request;
	}
	
	private String creteReservationRequest() {
		
		return "{\r\n" + 
				"  \"code\": \"RX1289\",\r\n" + 
				"  \"date\": \"2019-11-23\",\r\n" + 
				"  \"document\": \"1234567890\",\r\n" + 
				"  \"lastName\": \"Hinestroza\",\r\n" + 
				"  \"firstName\": \"Andres\",\r\n" + 
				"  \"birthDate\": \"1986-05-03\",\r\n" + 
				"  \"flights\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 3,\r\n" + 
				"      \"code\": \"AV368\",\r\n" + 
				"      \"initDate\": \"2019-11-25T18:22:00.000+0000\",\r\n" + 
				"      \"endDate\": \"2019-11-25T19:32:00.000+0000\",\r\n" + 
				"      \"source\": \"Medellin, CO\",\r\n" + 
				"      \"destiny\": \"Bogotá, CO\",\r\n" + 
				"      \"price\": 90000\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"id\": 5,\r\n" + 
				"      \"code\": \"AV368\",\r\n" + 
				"      \"initDate\": \"2019-11-26T18:22:00.000+0000\",\r\n" + 
				"      \"endDate\": \"2019-11-25T19:32:00.000+0000\",\r\n" + 
				"      \"source\": \"Medellin, CO\",\r\n" + 
				"      \"destiny\": \"Bogotá, CO\",\r\n" + 
				"      \"price\": 90000\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
	}
}
