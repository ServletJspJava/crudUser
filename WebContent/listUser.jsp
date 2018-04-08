<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
	<form method="post" name="frm" action="UserController?action=search">
		<table>
			<tr>
				<td>
					<h3>Search User</h3>
				</td>
			</tr>
			<tr>
				<td><b>User Name</b></td>
				<td>: <input type="text" name="username" id="username">
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" name="submit"
					value="search"></td>
			</tr>
		</table>
	</form>
	<table border=1>
		<thead>
			<tr>
				<th>User Id</th>
				<th>Fullname</th>
				<th>Gender</th>
				<th>email</th>
				<th>Username</th>
				<th>Role</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.idus}" /></td>
					<td><c:out value="${user.fullname}" /></td>
					<td><c:out value="${user.gender}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.role}" /></td>

					<td><a
						href="UserController?action=edit&idus=<c:out value="${user.idus}"/>">Update</a></td>
					<td><a
						href="UserController?action=delete&idus=<c:out value="${user.idus}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="UserController?action=insert">Add User</a>
	</p>
</body>
</html>