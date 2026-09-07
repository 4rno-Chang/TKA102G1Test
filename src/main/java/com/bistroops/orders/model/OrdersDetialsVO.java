package com.bistroops.orders.model;

import com.bistroops.meal.model.MealVO;
import com.bistroops.promote.model.PromoteVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="orders_detials", 
	uniqueConstraints =
	@UniqueConstraint(columnNames = { "orders_no", "meal_no" }))

public class OrdersDetialsVO {

	@ManyToOne
	@JoinColumn(name="ordersNo",referencedColumnName="ordersNo", nullable=false)
	private OrdersVO orders;
	
	@ManyToOne
	@JoinColumn(name="mealNo" ,referencedColumnName="mealNo", nullable=false)
	private MealVO mealNo;//Long?
	
	@ManyToOne 
	@JoinColumn(name="promoteNo" ,referencedColumnName="promoteNo")
	private PromoteVO promoteNo;//Long?
	
	@Column(name = "od_meal_num")
	private Integer odMealNum;
	
	@Column(name = "od_discount_price")
	private Integer odDiscountPrice;
	
	@Column(name = "od_discount_total")
	private Integer odDiscountTotal;
	
	@Column(name = "od_actual_price")
	private Integer odActualPrice;
	
	@Column(name = "od_comment")
	private String odComment;
	
	@Column(name = "od_status")
	private String odStatus;
	
	
	
}
