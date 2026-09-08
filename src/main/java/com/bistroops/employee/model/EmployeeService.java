package com.bistroops.employee.model;

import java.util.List;
import java.util.Map;



public interface EmployeeService {

    List<EmployeeVO> getAllEmployees(int currentPage);

    int getPageTotal();

    List<EmployeeVO> getEmployeesByCompositeQuery(Map<String, String[]> map);
    
    EmployeeVO getEmployeeById(Integer id);
    
    //Service 要提供一個「新增員工」功能，傳進來的是一整個 EmployeeVO
    void addEmployee(EmployeeVO employee);//新增
    
    void deleteEmployee(Integer id);//刪除
    
    void updateEmployee(EmployeeVO employee);//修改
}