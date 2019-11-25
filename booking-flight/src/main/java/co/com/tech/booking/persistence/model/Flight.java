package co.com.tech.booking.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flight")
@Getter
@Setter
public class Flight {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "INIT_DATE")
	private Date initDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "DESTINY")
	private String destiny;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@ManyToMany
	private List<Reservation> reservations;
}
