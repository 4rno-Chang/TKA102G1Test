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
	@JoinColumn(name="orders_no",referencedColumnName="orders_no", nullable=false)
	private OrdersVO orders;
	
	@ManyToOne
	@JoinColumn(name="meal_no" ,referencedColumnName="meal_no", nullable=false)
	private MealVO mealNo;
	
	@ManyToOne 
	@JoinColumn(name="promote_no" ,referencedColumnName="promote_no")
	private PromoteVO promoteNo;
	
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
