<%@page import="com.prg.dto.User"%>
<%@page import="com.prg.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
UserDao dao=new UserDao();
User user=dao.find(id);
%>
<h1>Enter Your Updated Details</h1><br>
<form action="update" method="post">
<table>
<tr>
<td>Id:</td>
<td><input type="text" name="id" value="<%=user.getId() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" value="<%=user.getName() %>" required="required"></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email" value="<%=user.getEmail() %>" required="required"></td>
</tr>
<tr>
<td>Phone:</td>
<td><input type="tel" name="phone" value="<%=user.getMobile() %>" required="required"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" value="<%=user.getPassword() %>" required="required"></td>
</tr>
<tr>
<td>
<button type="reset">Cancel</button>
</td>
<td>
<button type="submit">Update</button>
</td>
</tr>
</table>
</form>
</body>
</html>