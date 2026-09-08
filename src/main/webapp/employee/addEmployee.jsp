<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增員工</title>
</head>

<body>

<h1>新增員工</h1>

<form action="${pageContext.request.contextPath}/employee/employee.do" method="post">

    員工姓名：
    <input type="text" name="empName">
    <br><br>

    <%-- 員工密碼：
    <input type="text" name="empPassword">
    <br><br>--%>

    員工電話：
    <input type="text" name="empTel">
    <br><br>

    緊急聯絡人：
    <input type="text" name="empIce">
    <br><br>

    緊急聯絡電話：
    <input type="text" name="empIcetel">
    <br><br>

    地址：
    <input type="text" name="empAdd">
    <br><br>

    薪資：
    <input type="number" name="empSal">
    <br><br>

    員工狀態：
    <select name="empStatus">
        <option value="1">1</option>
        <option value="2">2</option>
    </select>
    <br><br>

    <!-- 告訴 EmployeeServlet 這次要執行 insert -->
    <input type="hidden" name="action" value="insert">

    <input type="submit" value="新增員工">

</form>

<br>

<a href="${pageContext.request.contextPath}/employee/index.jsp">回首頁</a>

</body>
</html>