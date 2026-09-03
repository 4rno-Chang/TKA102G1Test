package com.bistroops.meal.model;

import java.util.Arrays;
import java.util.Set;

import com.bistroops.mealtype.model.MealtypeVO;
import com.bistroops.promotemeal.model.PromoteMealVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal")
public class MealVO  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_no", updatable = false)
	private Integer mealNo;
	
	@ManyToOne
	@JoinColumn(name = "meal_type_no",referencedColumnName = "meal_type_no")
	private MealtypeVO mealType;
	
	@Column(name = "meal_name",nullable = false)
	private String mealName;
	
	@Column(name = "meal_img", columnDefinition = "mediumblob")
	private byte[] mealImg;
	
	@Column(name = "meal_exp", columnDefinition = "mediumtext")
	private String mealExp;
	
	@Column(name = "meal_price",nullable = false)
	private Integer mealPrice;
	
	@Column(name = "meal_status_en", columnDefinition = "enum('上架', '未上架')")
	private MealEnum mealStatusEn;

	@OneToMany(mappedBy="promoteMeals")
	@OrderBy("id")
	private Set<PromoteMealVO> promoteMeals;
	
	

	


	
	
}
