<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>複合查詢員工列表</title>
</head>
<body>
	<h1>複合查詢結果</h1>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/cat.png">
	<table border="1" style="width:50%; text-align:center;">
		<tr>
			<th>員工編號</th>
			<th>員工姓名</th>
			<th>員工電話</th>
			<th>緊急聯絡人</th>
			<th>緊急連絡電話</th>
			<th>地址</th>
			<th>薪資</th>
			<th>狀態</th>
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.empNo}</td>
				<td>${employee.empName}</td>
				<td>${employee.empTel}</td>
				<td>${employee.empIce}</td>
				<td>${employee.empIcetel}</td>
				<td>${employee.empAdd}</td>
				<td>${employee.empSal}</td>
				<td>${employee.empStatus}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<img width="140px" height="100px" alt="要飛囉貓貓" src="${pageContext.request.contextPath}/img/inversecat.png">
	<br><br>
	
	<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>	
</body>
</html>