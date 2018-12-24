<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Login 管理</title>
	</head>
	<body>
		<h1><center>管理台帳</center></h1>
		<form action="http://localhost:8080/kanridatyou/login/check" method="POST">
			<label style="position:absolute; top:120px; left:580px;">ログインID：</label>
    		<div style="position:absolute; top:120px; left:680px;">
    			<input type="text" name="LoginID" value="" required size="20" maxlength="8">
    		</div>
    		<label style="position:absolute; top:170px; left:580px;">パスワード：</label>
    		<div style="position:absolute; top:170px; left:680px;">
    			<input type="password" name="password" required value="" size="">
    		</div>
    		<div style="position:absolute; top:220px; left:680px;">
      			<input type="submit" value="ログイン">
    		</div>
    	</form>
		</body>
</html>