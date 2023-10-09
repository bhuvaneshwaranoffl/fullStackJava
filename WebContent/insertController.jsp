<%@ page import="luciDemoProject.Jdbc" %>
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
    String stuid = request.getParameter("stuid");
	String stuname = request.getParameter("stuname");
	String stuphn = request.getParameter("stuphn");
	
	//parse int
	int id = Integer.parseInt(stuid);
	
	//parse double
	double mobile = Double.parseDouble(stuphn);
	
	//call createConnection method from Jdbc.java file
	 Jdbc.createConnection();
	
	//call insertValues method from JdbcCrud.java file
	 Jdbc.insertValues(id,stuname,mobile);
	
 %>
    <a href = "index.html">Go Back</a> <br><br>
</body>
</html>