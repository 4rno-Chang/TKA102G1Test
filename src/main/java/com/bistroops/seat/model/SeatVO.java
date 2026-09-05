package com.bistroops.seat.model;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class SeatVO implements java.io.Serializable{

/*
	@ManyToOne
	@JoinColumn(name = "seat_type_no", referencedColumnName = "seat_type_no")
	private SeatType seatType;
*/	
/*
	@OneToMany(mappedBy = "seat_no", cascade = CascadeType.ALL)
	private Set<OrdersVO> orders;
*/

/*    seat_no CHAR(3) NOT NULL COMMENT '桌號',
  seat_type_no INT NOT NULL COMMENT '桌型編號',
  seat_status VARCHAR(5) COMMENT '桌位狀態',
  seat_time TIME COMMENT '入座時間',
*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seat_no")
	private String seatNo;
	
	@Column(name = "seat_type_no")
	private Integer seatTypeNo;
	
	@Column(name = "seat_status")
	private String seatStatus;
	
	@Column(name = "seat_time")
	private LocalTime seatTime;

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Integer getSeatTypeNo() {
		return seatTypeNo;
	}

	public void setSeatTypeNo(Integer seatTypeNo) {
		this.seatTypeNo = seatTypeNo;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public LocalTime getSeatTime() {
		return seatTime;
	}

	public void setSeatTime(LocalTime seatTime) {
		this.seatTime = seatTime;
	}

	

}
