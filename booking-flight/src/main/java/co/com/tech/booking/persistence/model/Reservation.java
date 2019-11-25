package co.com.tech.booking.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	private Date date;
	
	private String document;
	
	private String lastName;
	
	private String firstName;
	
	private Date birthDate;
	
	@ManyToMany
	private List<Flight> flights;
	
	public List<Flight> getFlights() {
		if(flights == null) {
			flights = new ArrayList<Flight>();
		}
		return flights;
	}
	 
}
