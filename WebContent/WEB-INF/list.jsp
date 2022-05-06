<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sach sinh vien</title>
<a href="${pageContext.request.contextPath}/CreateServlet">Thêm</a>
</head>
<body>
	<table  border="0" cellpadding="20" cellspacing="1">
		<tr>
			<th>ID</th>
			<th>Ho Ten</th>
			
			<th>Sửa</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items = "${list}" var = "item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>Sửa</td>
				<td>
					<a href="${pageContext.request.contextPath}/DeleteServlet?id=${item.id}">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>