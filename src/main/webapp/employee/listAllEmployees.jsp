<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>員工列表</title>
</head>
<body>
	<h1>員工列表</h1>
	<c:if test="${employeePageQty > 0}">
  		<b><font color=red>第${currentPage}/${employeePageQty}頁</font></b>
	</c:if>
	<br>
	
	<table border="1" style="width:80%; text-align:center; border-collapse:collapse;">
		<tr>
			<th>員工編號</th>
			<th>員工姓名</th>
			<th>員工電話</th>
			<th>緊急聯絡人</th>
			<th>緊急連絡電話</th>
			<th>地址</th>
			<th>薪資</th>
			<th>狀態</th>
			<th>操作</th>
			
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
				<td>
	            	<form action="${pageContext.request.contextPath}/employee/employee.do" method="post">
	                <input type="hidden" name="empNo" value="${employee.empNo}">
	                <input type="hidden" name="action" value="delete">
	                <input type="submit" value="刪除">
            		</form>
        		</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/employee/employee.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/employee/employee.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage + 1 <= employeePageQty}">
		<a href="${pageContext.request.contextPath}/employee/employee.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage != employeePageQty}">
		<a href="${pageContext.request.contextPath}/employee/employee.do?action=getAll&page=${employeePageQty}">至最後一頁</a>&nbsp;
	</c:if>
	<br>
	
	<br><br>
	
	<a href="${pageContext.request.contextPath}/employee/index.jsp">回首頁</a>	
</body>
</html>