<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>Announcement composite query</title>
</head>
<body>
	<h1>公告列表</h1>
	<br>
	<table style="width:50%; text-align:center;">
		<tr>
			<th>公告編號</th>
			<th>公告標題</th>
			<th>公告時間</th>
			<th>推播圖</th>
			<th>文字內容</th>
		</tr>
		<c:forEach var="ann" items="${annList}">
			<tr>
				<td>${ann.annNo}</td>
				<td>${ann.annTitle}</td>
				<td>${ann.annBegin}</td>
				<td>${ann.annImg}</td>
				<td>${ann.annText}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br><br>
	
	
	
	<a href="${pageContext.request.contextPath}/announcement/index.jsp">回首頁</a>	
</body>
</html>