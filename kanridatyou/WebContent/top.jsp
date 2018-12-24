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
        
  ArrayList<KanriDataDto> Kashidashi_info = (ArrayList<KanriDataDto>)session.getAttribute("kashidashi_info");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理台帳トップ</title>
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
	<% if(Kashidashi_info.size() == 0){ 
		String message = "<h2>貸出中のシステムはありません</h2>";%>
		<%=message %>
	<% }else{ %>
		<table border="1" width="500" >
			<tr>
				<th>システム名</th><th>貸出日</th><th>返却予定日</th><th>使用者</th><th>案件名</th>
			</tr>
			<% for(int i = 0; i < Kashidashi_info.size(); i++){ %>
			<tr>
				<td><%=Kashidashi_info.get(i).getSystemName() %></td>
				<td><%=Kashidashi_info.get(i).getKashidashiDate() %></td>
				<td><%=Kashidashi_info.get(i).getHenkyakuyoteiDate() %></td>
				<td><%=Kashidashi_info.get(i).getUserName() %></td>
				<td><%=Kashidashi_info.get(i).getAnkenName() %></td>
			</tr>
			<% } %>
		</table>
	<% } %>
</body>
</html>