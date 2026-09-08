<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>單一員工查詢</title>
</head>
<body>
 <h1>單一員工資料</h1>
<br>
	<table border="1" style="width:80%; text-align:center; border-collapse:collapse;">
	
        <tr>
            <th>員工編號</th>
            <td>${employee.empNo}</td>
        </tr>

        <tr>
            <th>員工姓名</th>
            <td>${employee.empName}</td>
        </tr>

        <tr>
            <th>員工電話</th>
            <td>${employee.empTel}</td>
        </tr>

        <tr>
            <th>緊急聯絡人</th>
            <td>${employee.empIce}</td>
        </tr>

        <tr>
            <th>緊急聯絡電話</th>
            <td>${employee.empIcetel}</td>
        </tr>

        <tr>
            <th>地址</th>
            <td>${employee.empAdd}</td>
        </tr>

        <tr>
            <th>薪資</th>
            <td>${employee.empSal}</td>
        </tr>

        <tr>
            <th>狀態</th>
            <td>${employee.empStatus}</td>
        </tr>
    </table>
    <br>

    <!-- 修改 -->
    <form action="${pageContext.request.contextPath}/employee/employee.do"
          method="post">

        <input type="hidden" name="empNo" value="${employee.empNo}">
        <input type="hidden" name="action" value="getOneForUpdate">

        <input type="submit" value="修改">
    </form>


    <!-- 刪除 -->
    <form action="${pageContext.request.contextPath}/employee/employee.do"
          method="post">

        <input type="hidden" name="empNo" value="${employee.empNo}">
        <input type="hidden" name="action" value="delete">

        <input type="submit" value="刪除">
     </form>
    
    <br>
	
	<br><br>
	
	<a href="${pageContext.request.contextPath}/employee/index.jsp">回首頁</a>	
</body>
</html>