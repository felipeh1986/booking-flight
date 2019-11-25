package co.com.tech.booking.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.tech.booking.persistence.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	List<Reservation> findByDocumentOrderByDateDesc(String document);
}
