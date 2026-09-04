package com.bistroops.reservation.model;

import java.time.LocalDateTime;

import com.bistroops.reservationdatetime.model.ReservationdatetimeVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "reservation")
public class ReservationVO  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rsv_no", updatable = false)
	private Integer rsvNo;
	
//	@ManyToOne
//	@JoinColumn(name = "mem_no", referencedColumnName = "mem_no")
//	private MemberVO member;
	
	@ManyToOne
	@JoinColumn(name = "rsv_dt_no", referencedColumnName = "rsv_dt_no")
	private ReservationdatetimeVO reservationdatetime; 
	
//	@ManyToOne
//	@JoinColumn(name = "seat_type_no", referencedColumnName = "seat_type_no")
//	private SeatTypeVO seatTypeNo;
	
	@Column(name= "rsv_create_time")
	private LocalDateTime rsvCreateTime;
	
	@Column(name = "rsv_status")
	private String rsvStatus;
	
	@Column(name = "rsv_comment")
	private String rsvComment;

	public Integer getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(Integer rsvNo) {
		this.rsvNo = rsvNo;
	}

	public ReservationdatetimeVO getReservationdatetime() {
		return reservationdatetime;
	}

	public void setReservationdatetime(ReservationdatetimeVO reservationdatetime) {
		this.reservationdatetime = reservationdatetime;
	}

	public LocalDateTime getRsvCreateTime() {
		return rsvCreateTime;
	}

	public void setRsvCreateTime(LocalDateTime rsvCreateTime) {
		this.rsvCreateTime = rsvCreateTime;
	}

	public String getRsvStatus() {
		return rsvStatus;
	}

	public void setRsvStatus(String rsvStatus) {
		this.rsvStatus = rsvStatus;
	}

	public String getRsvComment() {
		return rsvComment;
	}

	public void setRsvComment(String rsvComment) {
		this.rsvComment = rsvComment;
	}

	public ReservationVO(Integer rsvNo, ReservationdatetimeVO reservationdatetime, LocalDateTime rsvCreateTime,
			String rsvStatus, String rsvComment) {
		super();
		this.rsvNo = rsvNo;
		this.reservationdatetime = reservationdatetime;
		this.rsvCreateTime = rsvCreateTime;
		this.rsvStatus = rsvStatus;
		this.rsvComment = rsvComment;
	}
	
	
	
	
	
		
	
	
}
