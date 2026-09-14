package com.bistroops.meal.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bistroops.mealtype.model.MealtypeVO;

public interface MealDAO {
	
	public void insert(MealVO mealVO);

	public void update(MealVO mealVO);

	public void delete(Integer mealNo);

	public MealVO findByNo(Integer mealNo);

	public List<MealVO> getByComplexQuery(Map<String, String> map);
	
	public List<MealVO> getAll(int currentPage);

	public List<MealVO> getAll();
	
	public byte[] getPictureById(Integer mealNo);
}
