package com.bistroops.feedback.model;

import java.util.List;
import java.util.Map;

import com.bistroops.meal.model.MealVO;

public interface FeedBackDAO {

	public void insert(FeedBackVO FeedBackVO);

	public void update(FeedBackVO FeedBackVO);

	public void delete(Integer feedBackNo);

	public FeedBackVO findByNo(Integer feedBackNo);

	public List<FeedBackVO> getByComplexQuery(Map<String, String> map);

	public List<FeedBackVO> getAll();
	

}
