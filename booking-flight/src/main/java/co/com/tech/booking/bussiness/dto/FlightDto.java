package co.com.tech.booking.bussiness.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDto {

	private Integer id;
	private String code;
	private Date initDate;
	private Date endDate;
	private String source;
	private String destiny;
	private Integer price;
}
