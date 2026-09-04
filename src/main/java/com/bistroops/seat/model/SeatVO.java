package com.bistroops.seat.model;
import java.sql.Timestamp;
import java.time.LocalTime;

public class SeatVO implements java.io.Serializable{
	private String seatNo;
	private Integer seatTypeNo;
	private String seatStatus;
	private LocalTime seatTime;
	
	
	/*    seat_no CHAR(3) NOT NULL COMMENT '桌號',
  seat_type_no INT NOT NULL COMMENT '桌型編號',
  seat_status VARCHAR(5) COMMENT '桌位狀態',
  seat_time TIME COMMENT '入座時間',*/
}
