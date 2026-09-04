package com.bistroops.waiting.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "waiting")
public class WaitingVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "waiting_no")
	private Integer waitingNo;
	
//	@ManyToOne
//	@JoinColumn(name="seat_type_no", referencedColumnName = "seat_type_no")
//	private SeattypeVO seatType;
	
//	@ManyToOne
//	@JoinColumn(name = "member_no", referencedColumnName = "member_no")
//	private MemberVO member;
	
	@Column(name = "waiting_tel")
	private String waitingTEL;
	
	@Column(name = "waiting_name")
	private String waitingName;
	
	@Column(name = "waiting_comment")
	private String waitingComment;
	
	@Column(name = "waiting_status")
	private String waitingStatus;   
	
	@Column(name = "waiting_notify_time")
	private LocalTime waitingNotifyTime;
	
	
	
}
