<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="javax.servlet.*" import="javax.servlet.http.*" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

	
		// TODO Auto-generated method stub
		
		out.println("<html><body><center><h1>THE 2 PASSWORDS DONOT MATCH. PLEASE SIGN UP AGAIN </h1></center><br></body></html>");
		
		RequestDispatcher rd=request.getRequestDispatcher("EmployeeSignup.html");
		rd.include(request, response);
		


%>
</body>
</html>