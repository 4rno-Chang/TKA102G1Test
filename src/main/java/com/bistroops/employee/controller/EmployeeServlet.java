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
        
        case "insert":
            forwardPath = insertEmployee(req, res);
            break;
        
        case "getOne":
            forwardPath = getOneEmployee(req, res);
            break;
            
        case "getOneForUpdate":
            forwardPath = getOneForUpdate(req, res);
            break;            
            
        case "update":
            forwardPath = updateEmployee(req, res);
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
    
    private String insertEmployee(HttpServletRequest req, HttpServletResponse res) {

        String empName = req.getParameter("empName");
        String empTel = req.getParameter("empTel");
        String empIce = req.getParameter("empIce");
        String empIcetel = req.getParameter("empIcetel");
        String empAdd = req.getParameter("empAdd");
        String empSal = req.getParameter("empSal");
        String empStatus = req.getParameter("empStatus");

        // 防呆：必填欄位不能空白
        if (empName == null || empName.trim().isEmpty()
                || empTel == null || empTel.trim().isEmpty()
                || empIce == null || empIce.trim().isEmpty()
                || empIcetel == null || empIcetel.trim().isEmpty()
                || empAdd == null || empAdd.trim().isEmpty()
                || empSal == null || empSal.trim().isEmpty()
                || empStatus == null || empStatus.trim().isEmpty()) {

            req.setAttribute("errorMsg", "請完整填寫員工資料");
            return "/employee/addEmployee.jsp";
        }

        try {

            Integer salary = Integer.parseInt(empSal.trim());

            EmployeeVO employee = new EmployeeVO();

            employee.setEmpName(empName);
            employee.setEmpPassword("12345678");
            employee.setEmpTel(empTel);
            employee.setEmpIce(empIce);
            employee.setEmpIcetel(empIcetel);
            employee.setEmpAdd(empAdd);
            employee.setEmpSal(salary);
            employee.setEmpStatus(empStatus);

            employeeService.addEmployee(employee);

            req.getSession().removeAttribute("employeePageQty");

            return getAllEmployees(req, res);

        } catch (NumberFormatException e) {

            req.setAttribute("errorMsg", "薪資格式錯誤，請輸入數字");
            return "/employee/addEmployee.jsp";
        }
    }
    
    private String getOneEmployee(HttpServletRequest req, HttpServletResponse res) {

        // 防呆
        String empNoStr = req.getParameter("empNo");

        // 沒有輸入
        if (empNoStr == null || empNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入員工編號");
            return "/employee/index.jsp";
        }

        try {

            // 將輸入的字串轉成 Integer
            Integer empNo = Integer.parseInt(empNoStr.trim());

            // 查詢員工
            EmployeeVO employee = employeeService.getEmployeeById(empNo);

            // 查不到此員工
            if (employee == null) {
                req.setAttribute("errorMsg", "查無此員工編號" );
                return "/employee/index.jsp";
            }

            // 查詢成功
            req.setAttribute("employee", employee);
            return "/employee/listOneEmployee.jsp";

        } catch (NumberFormatException e) {

            // 輸入的不是數字
            req.setAttribute("errorMsg", "員工編號格式錯誤");
            return "/employee/index.jsp";
        }
    }
    
    private String getOneForUpdate(HttpServletRequest req, HttpServletResponse res) {

        String empNo = req.getParameter("empNo");

        Integer id = Integer.valueOf(empNo);

        EmployeeVO employee = employeeService.getEmployeeById(id);

        req.setAttribute("employee", employee);

        return "/employee/editEmployee.jsp";
    }
    
    private String updateEmployee(HttpServletRequest req, HttpServletResponse res) {

        String empNo = req.getParameter("empNo");
        String empName = req.getParameter("empName");
        String empTel = req.getParameter("empTel");
        String empIce = req.getParameter("empIce");
        String empIcetel = req.getParameter("empIcetel");
        String empAdd = req.getParameter("empAdd");
        String empSal = req.getParameter("empSal");
        String empStatus = req.getParameter("empStatus");

        Integer id = Integer.valueOf(empNo);

        // 先查出原本的員工
        EmployeeVO employee = employeeService.getEmployeeById(id);

        // 修改允許修改的資料
        employee.setEmpName(empName);
        employee.setEmpTel(empTel);
        employee.setEmpIce(empIce);
        employee.setEmpIcetel(empIcetel);
        employee.setEmpAdd(empAdd);
        employee.setEmpSal(Integer.valueOf(empSal));
        employee.setEmpStatus(empStatus);

        // 更新
        employeeService.updateEmployee(employee);

        return getAllEmployees(req, res);
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

        String empName = req.getParameter("empName");
        String empTel = req.getParameter("empTel");
        String empAdd = req.getParameter("empAdd");
        String empStatus = req.getParameter("empStatus");
        String empSal = req.getParameter("empSal");

        // 防呆：全部查詢條件都沒有輸入
        if ((empName == null || empName.trim().isEmpty())
                && (empTel == null || empTel.trim().isEmpty())
                && (empAdd == null || empAdd.trim().isEmpty())
                && (empStatus == null || empStatus.trim().isEmpty())
                && (empSal == null || empSal.trim().isEmpty())) {

            req.setAttribute("compositeErrorMsg", "請至少輸入一項查詢條件");
            return "/employee/index.jsp";
        }

        Map<String, String[]> map = req.getParameterMap();

        List<EmployeeVO> employeeList =
                employeeService.getEmployeesByCompositeQuery(map);

        req.setAttribute("employeeList", employeeList);

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