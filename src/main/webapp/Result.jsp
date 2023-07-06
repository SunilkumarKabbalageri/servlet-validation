<%@page import="com.prg.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<User> list=(List<User>)request.getAttribute("list");%>

<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%for(User user:list){%>
<tr>
<th><%=user.getId() %></th>
<th><%=user.getName() %></th>
<th><%=user.getEmail() %></th>
<th><%=user.getMobile() %></th>
<th><%=user.getPassword() %></th>
<th><a href="edit.jsp?id=<%=user.getId()%>"><button>Edit</button></a></th>
<th><a href="delete?id=<%=user.getId()%>"><button>Delete</button></a></th>
</tr>
<%} %>
</table>
<br>
<a href="Login.html"><button>Logout</button> </a>
</body>
</html>