package com.bistroops.employee.model;

import java.util.List;
import java.util.Map;



public interface EmployeeDAO {
	
	void insert (EmployeeVO entity);
	void update (EmployeeVO entity);
	void delete (Integer id);
	EmployeeVO getById(Integer id);
	List<EmployeeVO> getAll();
	List<EmployeeVO> getByCompositeQuery(Map<String,String>map);
	List<EmployeeVO> getAll(int currentPage);
	long getTotal();

}
