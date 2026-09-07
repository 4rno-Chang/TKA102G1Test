package com.bistroops.orders.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class OrdersVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ordersNo")
	private Integer ordersNo;
	
	@Column(name="seatNo")
	private String seatNo;
	
	@Column(name="memberNo")
	private Integer memberNo;
	
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
	
	
	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersVO(Integer ordersNo, String seatNo, Integer memberNo, LocalDateTime ordersTime, Integer ordersTotal,
			Integer ordersDiscountTotal, Integer ordersActualPrice, String ordersPay) {
		super();
		this.ordersNo = ordersNo;
		this.seatNo = seatNo;
		this.memberNo = memberNo;
		this.ordersTime = ordersTime;
		this.ordersTotal = ordersTotal;
		this.ordersDiscountTotal = ordersDiscountTotal;
		this.ordersActualPrice = ordersActualPrice;
		this.ordersPay = ordersPay;
	}
	

}
