package com.bistroops.employee.model;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeVO> getAllEmployees(int currentPage);

    int getPageTotal();

    List<EmployeeVO> getEmployeesByCompositeQuery(Map<String, String[]> map);
    
    EmployeeVO getEmployeeById(Integer id);
}