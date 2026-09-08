<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改員工</title>
</head>

<body>

    <h1>修改員工資料</h1>

    <form action="${pageContext.request.contextPath}/employee/employee.do"
          method="post">

        員工編號：
        <input type="text"
               name="empNo"
               value="${employee.empNo}"
               readonly>
        <br><br>

        員工姓名：
        <input type="text"
               name="empName"
               value="${employee.empName}">
        <br><br>

        員工電話：
        <input type="text"
               name="empTel"
               value="${employee.empTel}">
        <br><br>

        緊急聯絡人：
        <input type="text"
               name="empIce"
               value="${employee.empIce}">
        <br><br>

        緊急聯絡電話：
        <input type="text"
               name="empIcetel"
               value="${employee.empIcetel}">
        <br><br>

        員工地址：
        <input type="text"
               name="empAdd"
               value="${employee.empAdd}">
        <br><br>

        員工薪資：
        <input type="number"
               name="empSal"
               value="${employee.empSal}">
        <br><br>

        員工狀態：
        <input type="text"
               name="empStatus"
               value="${employee.empStatus}">
        <br><br>

        <input type="hidden" name="action" value="update">

        <input type="submit" value="確認修改">

    </form>
	<br>

<a href="${pageContext.request.contextPath}/employee/index.jsp">回首頁</a>
</body>

</html>