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

	public OrdersDetialsVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersVO getOrders() {
		return orders;
	}

	public void setOrders(OrdersVO orders) {
		this.orders = orders;
	}

	public MealVO getMealNo() {
		return mealNo;
	}

	public void setMealNo(MealVO mealNo) {
		this.mealNo = mealNo;
	}

	public PromoteVO getPromoteNo() {
		return promoteNo;
	}

	public void setPromoteNo(PromoteVO promoteNo) {
		this.promoteNo = promoteNo;
	}

	public Integer getOdMealNum() {
		return odMealNum;
	}

	public void setOdMealNum(Integer odMealNum) {
		this.odMealNum = odMealNum;
	}

	public Integer getOdDiscountPrice() {
		return odDiscountPrice;
	}

	public void setOdDiscountPrice(Integer odDiscountPrice) {
		this.odDiscountPrice = odDiscountPrice;
	}

	public Integer getOdDiscountTotal() {
		return odDiscountTotal;
	}

	public void setOdDiscountTotal(Integer odDiscountTotal) {
		this.odDiscountTotal = odDiscountTotal;
	}

	public Integer getOdActualPrice() {
		return odActualPrice;
	}

	public void setOdActualPrice(Integer odActualPrice) {
		this.odActualPrice = odActualPrice;
	}

	public String getOdComment() {
		return odComment;
	}

	public void setOdComment(String odComment) {
		this.odComment = odComment;
	}

	public String getOdStatus() {
		return odStatus;
	}

	public void setOdStatus(String odStatus) {
		this.odStatus = odStatus;
	}
	
	
	
}
