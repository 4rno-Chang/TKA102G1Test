<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>Hibernate Demo</title>
</head>
<body>

    <h1>這是一位後端人員作的網頁 QQ</h1>
    <h2>員工系統</h2>
    <!-- 新增員工 -->
    <a href="${pageContext.request.contextPath}/employee/addEmployee.jsp">新增員工</a>

    <!-- 查全部 -->
    <a href="${pageContext.request.contextPath}/employee/employee.do?action=getAll">
        查詢所有員工
    </a>

    <br><br>

    <!-- 複合查詢 -->
    <h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
	<p style="color:red;">${compositeErrorMsg}</p>
    <form action="${pageContext.request.contextPath}/employee/employee.do" method="post">

        <p><label>員工名字模糊查詢：</label></p>
        <input type="text" name="empName"><br>

        <p><label>員工電話：</label></p>
        <input type="text" name="empTel"><br>

        <p><label>員工地址：</label></p>
        <input type="text" name="empAdd"><br>

        <p><label>員工狀態：</label></p>
        <input type="text" name="empStatus"><br>

        <p><label>員工薪資：</label></p>
        <input type="text" name="empSal"><br>

        <p><input type="submit" value="送出"></p>

        <input type="hidden" name="action" value="compositeQuery">

    </form>


    <!-- 查單一 -->
    <h3>查詢單一員工</h3>
    
    <p style="color:red;">${errorMsg}</p>

    <form action="${pageContext.request.contextPath}/employee/employee.do" method="post">

        員工編號：
        <input type="text" name="empNo">

        <input type="hidden" name="action" value="getOne">

        <input type="submit" value="查詢">

    </form>


</body>
</html>