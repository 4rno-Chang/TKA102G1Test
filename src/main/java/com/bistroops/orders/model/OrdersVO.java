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
	@Column(name="ordersNo")
	private Integer ordersNo;
	
	@ManyToOne
	@JoinColumn(name="seatNo")
	private SeatVO seatNo;
	
	@ManyToOne
	@JoinColumn(name="memberNo")
	private MemberVO memberNo;
	
	@Column(name="ordersTime")
	private LocalDateTime ordersTime;
	
	@Column(name="ordersTotal")
	private Integer ordersTotal;
	
	@Column(name="ordersDiscountTotal")
	private Integer ordersDiscountTotal;
	
	@Column(name="ordersActualPrice")
	private Integer ordersActualPrice;
	
	@Column(name="ordersPay" ,columnDefinition="varchar(2)")
	private String ordersPay;
	
	
	@OneToMany(mappedBy="orders")
	private Set<OrdersDetialsVO> orders;
	
	
//	@OneToMany(mappedBy="feedBackNo")
//	private Set<FeedBackVO> feedBack;
	
	
	
	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrdersVO(Integer ordersNo, SeatVO seatNo, MemberVO memberNo, LocalDateTime ordersTime, Integer ordersTotal,
			Integer ordersDiscountTotal, Integer ordersActualPrice, String ordersPay, Set<OrdersDetialsVO> orders) {
		super();
		this.ordersNo = ordersNo;
		this.seatNo = seatNo;
		this.memberNo = memberNo;
		this.ordersTime = ordersTime;
		this.ordersTotal = ordersTotal;
		this.ordersDiscountTotal = ordersDiscountTotal;
		this.ordersActualPrice = ordersActualPrice;
		this.ordersPay = ordersPay;
		this.orders = orders;
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
		return orders;
	}

	public void setOrders(Set<OrdersDetialsVO> orders) {
		this.orders = orders;
	}


}
