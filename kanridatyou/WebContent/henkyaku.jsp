<%@page import="org.UserDataDto"%>
<%@page import="org.KanriDataDto"%>
<%@page import="org.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/kanridatyou/css/style_Biz_source.css">
<%
  UserDataDto dto = (UserDataDto)session.getAttribute("userinfo");
        if( dto == null){
            dto = new UserDataDto();
        }
  		request.setCharacterEncoding("UTF-8"); 
        String user_name = dto.getUserName();
        
  ArrayList<KanriDataDto> Kashidashi_info = (ArrayList<KanriDataDto>)request.getAttribute("resultData");
  int num = (int)request.getAttribute("num");
  ArrayList<KanriDataDto> system_info = (ArrayList<KanriDataDto>)session.getAttribute("system_info");
%>
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
	<form action="http://localhost:8080/kanridatyou/henkyaku/result" method="POST">
		<p>システム名</p>
		<p><%=Kashidashi_info.get(num).getSystemName() %></p>
		<input type="hidden" name="system_name" value=<%=Kashidashi_info.get(num).getSystemName() %>></input>
		<br>
		<p>貸出日</p>
		<p><%= Kashidashi_info.get(num).getKashidashiDate() %></p>
		<input type="hidden" name="kashidashi_date" value=<%=Kashidashi_info.get(num).getKashidashiDate() %>></input>
		<br>
		<p>返却予定日</p>
		<p><%= Kashidashi_info.get(num).getHenkyakuyoteiDate()%></p>
		<input type="hidden" name="henkyaku_yoteibi" value=<%=Kashidashi_info.get(num).getHenkyakuyoteiDate() %> ></input>
		<br>
		<p>貸出日</p>
		<input type="date" name="henkyaku_date" required></input>
		<br>
		<p>案件名</p>
		<p><%= Kashidashi_info.get(num).getAnkenName()%></p>
		<input type="hidden" name="ankenmei" value=<%=Kashidashi_info.get(num).getAnkenName() %>></input>
		<br>
		<input type="hidden" name="user_name" value=<%=user_name %>>
		<br>
		<input type="submit" name="update" value="返却">
	</form>	
</body>
</html>