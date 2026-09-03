package com.bistroops.promotemeal.model;



import com.bistroops.meal.model.MealVO;
import com.bistroops.promote.model.PromoteVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="promote_meal")
public class PromoteMealVO {
	
	@Id
	@ManyToOne
	@JoinColumn(name="promote_no", referencedColumnName = "promote_no")
	private PromoteVO promote;
	
	@ManyToOne
	@JoinColumn(name="meal_no", referencedColumnName = "meal_no")
	private MealVO mealNo;
	
	@Column(name="promote_discount")
	private Integer promoteDiscount;

	public PromoteMealVO() {
	}

	

}
