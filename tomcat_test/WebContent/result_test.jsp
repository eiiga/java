<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="tomcat_test.datadto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	
	<!-- datadtoからデータを呼び出し表示させる -->
	<%  datadto data = (datadto)request.getAttribute("Data");
		 out.print(data.GetWord());
			%>
</body>
</html>