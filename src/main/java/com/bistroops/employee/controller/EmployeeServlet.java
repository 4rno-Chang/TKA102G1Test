package com.bistroops.employee.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.bistroops.employee.model.EmployeeVO;
import com.bistroops.employee.model.EmployeeService;
import com.bistroops.employee.model.EmployeeServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employee/employee.do")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        String forwardPath = "";

        switch (action) {
        
        case "getOne":
            forwardPath = getOneEmployee(req, res);
            break;
            
        case "insert":
            forwardPath = insertEmployee(req, res);
            break;
            
        case "delete":
            forwardPath = deleteEmployee(req, res);
            break;

        case "getAll":
            forwardPath = getAllEmployees(req, res);
            break;

        case "compositeQuery":
            forwardPath = getCompositeEmployeesQuery(req, res);
            break;

        default:
            forwardPath = "/employee/index.jsp";
        }

        res.setContentType("text/html; charset=UTF-8");

        RequestDispatcher dispatcher =
                req.getRequestDispatcher(forwardPath);

        dispatcher.forward(req, res);
    }
    
    private String insertEmployee(HttpServletRequest req,HttpServletResponse res) {

        String empName = req.getParameter("empName");// 從前端表單取得員工姓名
        //String empPassword = req.getParameter("empPassword");// 從前端表單取得員工密碼
        String empTel = req.getParameter("empTel");// 從前端表單取得員工電話
        String empIce = req.getParameter("empIce");// 從前端表單取得緊急聯絡人
        String empIcetel = req.getParameter("empIcetel");// 從前端表單取得緊急聯絡人電話
        String empAdd = req.getParameter("empAdd");// 從前端表單取得員工地址
        String empSal = req.getParameter("empSal");// 從前端表單取得員工薪資
        String empStatus = req.getParameter("empStatus");// 從前端表單取得員工狀態

        EmployeeVO employee = new EmployeeVO();

        employee.setEmpName(empName);
        //employee.setEmpPassword(empPassword);
        employee.setEmpPassword("12345678"); // 新增員工時設定預設密碼
        employee.setEmpTel(empTel);
        employee.setEmpIce(empIce);
        employee.setEmpIcetel(empIcetel);
        employee.setEmpAdd(empAdd);
        employee.setEmpSal(Integer.valueOf(empSal));
        employee.setEmpStatus(empStatus);

        employeeService.addEmployee(employee);

        req.getSession().removeAttribute("employeePageQty");

        return getAllEmployees(req, res);
    }
    
    private String getOneEmployee(HttpServletRequest req, HttpServletResponse res) {

        String empNo = req.getParameter("empNo");
        
        // 沒有輸入員工編號
        if (empNo == null || empNo.trim().isEmpty()) {
            return "/employee/index.jsp";
        }


        Integer id = Integer.valueOf(empNo);

        EmployeeVO employee = employeeService.getEmployeeById(id);

        req.setAttribute("employee", employee);

        return "/employee/listOneEmployee.jsp";
    }
    
    private String deleteEmployee(
            HttpServletRequest req,
            HttpServletResponse res) {

        String empNo = req.getParameter("empNo");

        Integer id = Integer.valueOf(empNo);

        employeeService.deleteEmployee(id);
        
        req.getSession().removeAttribute("employeePageQty");

        return getAllEmployees(req, res);
    }

    private String getAllEmployees(
            HttpServletRequest req,
            HttpServletResponse res) {

        String page = req.getParameter("page");

        int currentPage =
                (page == null) ? 1 : Integer.parseInt(page);

        List<EmployeeVO> employeeList =
                employeeService.getAllEmployees(currentPage);

        if (req.getSession().getAttribute("employeePageQty") == null) {

            int employeePageQty =
                    employeeService.getPageTotal();

            req.getSession()
                    .setAttribute("employeePageQty", employeePageQty);
        }

        req.setAttribute("employeeList", employeeList);
        req.setAttribute("currentPage", currentPage);

        return "/employee/listAllEmployees.jsp";
    }

    private String getCompositeEmployeesQuery(
            HttpServletRequest req,
            HttpServletResponse res) {

        Map<String, String[]> map = req.getParameterMap();

        if (map != null) {

            List<EmployeeVO> employeeList =
                    employeeService.getEmployeesByCompositeQuery(map);

            req.setAttribute("employeeList", employeeList);

        } else {

            return "/employee/index.jsp";
        }

        return "/employee/listCompositeQueryEmployees.jsp";
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        doPost(req, res);
    }
}