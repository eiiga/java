<%@page import="org.UserDataDto"%>
<%@page import="org.KanriDataDto"%>
<%@page import="org.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  UserDataDto dto = (UserDataDto)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDto();
        }
  		request.setCharacterEncoding("UTF-8"); 
        String user_name = dto.getUserName();
        
  ArrayList<KanriDataDto> system_info = (ArrayList<KanriDataDto>)session.getAttribute("system_info");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div style="position:absolute; top:10px; right:20px;">
			<%=JumsHelper.getInstance().home()%>
		</div>
		<div style="position:absolute; top:10px; right:140px;">
			<%=JumsHelper.getInstance().Logout()%>
		</div>
		<div style="position:absolute; top:30px; right:50px;">
			<p>ユーザ名：<%=user_name%> </p>
		</div>
			<h1><center>管理台帳</center></h1>
	</header>
	<form method="post" action="http://localhost:8080/kanridatyou/Kashidashi/result">
		<select name="systemID">
			<% for(int i = 0; i < system_info.size(); i++){ %>
				<option value=<%=system_info.get(i).getSystemID() %>><%=system_info.get(i).getSystemName() %></option>
			<%} %>
		</select>
		<input type="date" name="kashidashi_date"></input>
		<input type="date" name="henkyaku_yoteibi" ></input>
		<input type="text" name="ankenmei" value=""></input>
		<input type="hidden" name="user_name" value=<%=user_name %>>
		<input type="submit" name="kashidashi" value="貸出">
	</form>
</body>
</html>