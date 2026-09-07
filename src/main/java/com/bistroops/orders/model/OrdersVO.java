package com.bistroops.orders.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.bistroops.member.model.MemberVO;
import com.bistroops.seat.model.SeatVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrdersVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orders_no")
	private Integer ordersNo;
	
	@ManyToOne
	@JoinColumn(name="seat_no")
	private SeatVO seatNo;
	
	@ManyToOne
	@JoinColumn(name="member_no")
	private MemberVO memberNo;
	
	@Column(name="orders_time")
	private LocalDateTime ordersTime;
	
	@Column(name="orders_total")
	private Integer ordersTotal;
	
	@Column(name="orders_discount_total")
	private Integer ordersDiscountTotal;
	
	@Column(name="orders_actual_price")
	private Integer ordersActualPrice;
	
	@Column(name="orders_pay")
	private String ordersPay;
	
	
	@OneToMany(mappedBy="orders")
	private Set<OrdersDetialsVO> ordersDetials;
	

//	@OneToMany(mappedBy="feedBackNo")
//	private Set<FeedBackVO> feedBack;
	
	
	
	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOrdersNo() {
		return ordersNo;
	}

	public void setOrdersNo(Integer ordersNo) {
		this.ordersNo = ordersNo;
	}

	public SeatVO getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(SeatVO seatNo) {
		this.seatNo = seatNo;
	}


	public MemberVO getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(MemberVO memberNo) {
		this.memberNo = memberNo;
	}

	public LocalDateTime getOrdersTime() {
		return ordersTime;
	}

	public void setOrdersTime(LocalDateTime ordersTime) {
		this.ordersTime = ordersTime;
	}

	public Integer getOrdersTotal() {
		return ordersTotal;
	}

	public void setOrdersTotal(Integer ordersTotal) {
		this.ordersTotal = ordersTotal;
	}

	public Integer getOrdersDiscountTotal() {
		return ordersDiscountTotal;
	}

	public void setOrdersDiscountTotal(Integer ordersDiscountTotal) {
		this.ordersDiscountTotal = ordersDiscountTotal;
	}

	public Integer getOrdersActualPrice() {
		return ordersActualPrice;
	}

	public void setOrdersActualPrice(Integer ordersActualPrice) {
		this.ordersActualPrice = ordersActualPrice;
	}

	public String getOrdersPay() {
		return ordersPay;
	}

	public void setOrdersPay(String ordersPay) {
		this.ordersPay = ordersPay;
	}

	public Set<OrdersDetialsVO> getOrders() {
		return ordersDetials;
	}

	public void setOrders(Set<OrdersDetialsVO> orders) {
		this.ordersDetials = orders;
	}


}
