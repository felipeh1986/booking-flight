package co.com.tech.booking.bussiness.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingSearchRequest {

	private Date initDate;
	private Date endDate;
	private String source;
	private String destiny;
	private boolean oneWay;
}
