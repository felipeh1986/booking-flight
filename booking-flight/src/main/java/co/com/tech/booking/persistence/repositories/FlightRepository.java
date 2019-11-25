package co.com.tech.booking.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.tech.booking.persistence.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	List<Flight> findByInitDateBetweenAndSourceAndDestiny(Date initDate, Date endDate, String source, String destiny);

}
