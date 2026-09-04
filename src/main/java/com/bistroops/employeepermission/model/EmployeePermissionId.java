package com.bistroops.employeepermission.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

	@Embeddable
	public class EmployeePermissionId implements Serializable {

	    @Column(name = "emp_no")
	    private Integer empNo;

	    @Column(name = "perm_no")
	    private Integer permNo;

	    public EmployeePermissionId() {
	    }

	    public EmployeePermissionId(Integer empNo, Integer permNo) {
	        this.empNo = empNo;
	        this.permNo = permNo;
	    }

	    public Integer getEmpNo() {
	        return empNo;
	    }

	    public void setEmpNo(Integer empNo) {
	        this.empNo = empNo;
	    }

	    public Integer getPermNo() {
	        return permNo;
	    }

	    public void setPermNo(Integer permNo) {
	        this.permNo = permNo;
	    }
	}


