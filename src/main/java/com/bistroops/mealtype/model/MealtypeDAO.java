package com.bistroops.mealtype.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bistroops.meal.model.MealVO;

public interface MealtypeDAO {
	//xx
	public void insert(MealtypeVO mealtypeVO);

	public void update(MealtypeVO mealtypeVO);

	public void delete(Integer mealtypeNo);

	public MealtypeVO findByNo(Integer mealtypeNo);

	public List<MealtypeVO> getByNameQuery(String name);
	
	public Set<MealVO> getMealByTpye(Integer mealtypeNo);

	public List<MealtypeVO> getAll();
	
}
