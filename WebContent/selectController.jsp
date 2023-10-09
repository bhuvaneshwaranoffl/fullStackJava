<%@ page import="luciDemoProject.Jdbc, java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
  body{
    background: linear-gradient(to right, rgba(255,0,0,0), rgba(255,0,0,1));
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%
	
	//call JDBC createConnection method
	Jdbc.createConnection();
	
	//call JDBC selectValues method
	try {
		ResultSet rs = Jdbc.selectValues();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double salary = rs.getDouble(3);
			out.println(id + "  "+name+"   "+salary+"<br>");
		}
	} catch (Exception e) {
		System.out.println(e);
	}
   %>
      <a href = "index.html">Go Back</a> <br><br>
</body>
</html>