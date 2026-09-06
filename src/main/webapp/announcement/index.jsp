<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告設定</title>
</head>
<body>
	<h1>公告設定</h1>
	<a href="${pageContext.request.contextPath}/ann/ann.do?action=getAll">查看所有公告</a>
	<br>
	<br>
	<form action="${pageContext.request.contextPath}/ann/ann.do"
		method="post">
		<p>
			<label>公告編號查詢：</label>
		</p>
		<input type="text" name="annNo"><br>
		<input type="hidden" name="action" value="annNoQuery">
		<p>
			<input type="submit" value="查詢">
		</p>
	</form>
	<br>
	<br>

</body>
</html>