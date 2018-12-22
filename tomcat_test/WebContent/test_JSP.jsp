<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Web Test</title>
</head>
<body>
	<!-- 値を入力し、データを送信 -->
	<form action=http://localhost:8080/tomcat_test/test method="GET">
		<input type="text" name="name" value="" >
		<input type="submit" value="クリック！">
	</form>
</body>
</html>