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
public class ReservationDatetimeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rsv_dt_no")
	private Integer rsvDtNo;
	
	@Column(name = "rsv_dt_datetime")
	private LocalDateTime rsvDtDatetime;
	
	@OneToMany(mappedBy = "reservationdatetime")
	@OrderBy("rsvNo asc")
	private Set<ReservationVO> reservations;

	public Integer getRsvDtNo() {
		return rsvDtNo;
	}

	public void setRsvDtNo(Integer rsvDtNo) {
		this.rsvDtNo = rsvDtNo;
	}

	public LocalDateTime getRsvDtDatetime() {
		return rsvDtDatetime;
	}

	public void setRsvDtDatetime(LocalDateTime rsvDtDatetime) {
		this.rsvDtDatetime = rsvDtDatetime;
	}

	public Set<ReservationVO> getReservations() {
		return reservations;
	}

	public void setReservations(Set<ReservationVO> reservations) {
		this.reservations = reservations;
	}

	public ReservationDatetimeVO(Integer rsvDtNo, LocalDateTime rsvDtDatetime, Set<ReservationVO> reservations) {
		
		this.rsvDtNo = rsvDtNo;
		this.rsvDtDatetime = rsvDtDatetime;
		this.reservations = reservations;
	}
	
	public ReservationDatetimeVO() {
		
	}
	
	
}

