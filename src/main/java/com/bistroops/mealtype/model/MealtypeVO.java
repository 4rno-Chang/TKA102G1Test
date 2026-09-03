package com.bistroops.mealtype.model;

import java.util.Set;

import com.bistroops.meal.model.MealVO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal_type")
public class MealtypeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mealTypeNO", updatable = false)
	private Integer mealTypeNo;

	@Column(name = "meal_type_name")
	private String mealTypeName;
	
	@OneToMany(mappedBy="MealVO",cascade = CascadeType.ALL)
	@OrderBy("mealNo asc")
	private Set<MealVO> meals;

	public Integer getMealTypeNo() {
		return mealTypeNo;
	}

	public void setMealTypeNo(Integer mealTypeNo) {
		this.mealTypeNo = mealTypeNo;
	}

	public String getMealTypeName() {
		return mealTypeName;
	}

	public void setMealTypeName(String mealTypeName) {
		this.mealTypeName = mealTypeName;
	}

	@Override
	public String toString() {
		return "MealtypeVO [mealTypeNo=" + mealTypeNo + ", mealTypeName=" + mealTypeName + "]";
	}

}
