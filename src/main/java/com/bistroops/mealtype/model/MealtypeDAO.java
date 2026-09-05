package com.bistroops.mealtype.model;

import java.util.*;

public interface MealtypeDAO {
	
	public void insert(MealtypeVO MealtypeVO);

	public void update(MealtypeVO MealtypeVO);

	public void delete(Integer mealTypeNo);

	public MealtypeVO findByPrimaryKey(Integer mealTypeNo);

	public MealtypeVO findByPrimaryKey(String mealTypeName);

	public List<MealtypeVO> getAll();
	
	public long getTotal();

}
