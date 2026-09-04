package com.bistroops.reservationdatetime.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.bistroops.reservation.model.ReservationVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation_datetime")
public class ReservationdatetimeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rsv_dt_no")
	private Integer rsvDtNo;
	
	@Column(name = "rsv_dt_datetime")
	private LocalDateTime rsvDtDatetime;
	
	@OneToMany(mappedBy = "reservationdatetime")
	@OrderBy("rsvNo asc")
	private Set<ReservationVO> reservations;
}
