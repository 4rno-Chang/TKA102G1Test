package com.bistroops.reservation.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class ReservationVO implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rsv_no", updatable = false)
	private Integer rsvNo;
	
	@Column(name = "mem_no", updatable = false)
	private Integer memNo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rsv_dt_no", referencedColumnName = "rsv_dt_no")
	private Integer rsvDtNo;
	
	@Column(name = "seat_type_no", updatable = false)
	private Integer seatTypeNo;
	
	@Column(name = "rsv_create_time")
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
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public Integer getRsvDtNo() {
		return rsvDtNo;
	}
	public void setRsvDtNo(Integer rsvDtNo) {
		this.rsvDtNo = rsvDtNo;
	}
	public Integer getSeatTypeNo() {
		return seatTypeNo;
	}
	public void setSeatTypeNo(Integer seatTypeNo) {
		this.seatTypeNo = seatTypeNo;
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
	public ReservationVO(Integer rsvNo, Integer memNo, Integer rsvDtNo, Integer seatTypeNo, LocalDateTime rsvCreateTime,
			String rsvStatus, String rsvComment) {
		super();
		this.rsvNo = rsvNo;
		this.memNo = memNo;
		this.rsvDtNo = rsvDtNo;
		this.seatTypeNo = seatTypeNo;
		this.rsvCreateTime = rsvCreateTime;
		this.rsvStatus = rsvStatus;
		this.rsvComment = rsvComment;
	}
}
