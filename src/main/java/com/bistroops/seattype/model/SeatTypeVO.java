package com.bistroops.seattype.model;
import java.util.Set;
import com.bistroops.reservation.model.ReservationVO;
import com.bistroops.seat.model.SeatVO;
import com.bistroops.waiting.model.WaitingVO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="seat_type")
public class SeatTypeVO {
	
	@Id
	@Column(name = "seat_type_no",nullable=false)
	private String seatTypeNo;
	
	@Column(name = "seat_type_num")
	private Integer seatTypeNum;
	
	@Column(name = "seat_type_rsv_num")
	private Integer seatTypeRsvNum;
	
	@Column(name = "seat_type_take_num")
	private Integer seatTypeTakeNum;
	
	@Column(name = "seat_type_call_num")
	private Integer seatTypeCallNum;
	
	@Column(name = "seat_type_pending")
	private Integer seatTypePending;
	
	//候位
	@OneToMany(mappedBy="waiting")//cascade=CascadeTypr.ALL
	private Set<WaitingVO> waiting;
	
	//桌位
	@OneToMany(mappedBy="seat")
	private Set<SeatVO> seat;
	
	
	//預約明細
	@OneToMany(mappedBy="reservation")
	private Set<ReservationVO> reservation;
	
	
}
