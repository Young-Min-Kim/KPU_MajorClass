<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생 등록</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header>[학생 정보 등록]</header>
		<form name=form1 action="http://localhost:8080/myweb/member/register/" method="post">
		<table>	
			<tr><th>LoginID</th><td><input type="text" name="id" autofocus placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>UserName</th><td><input type="text" name="name" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>StudentNumber</th><td><input type="text" name="studentNum"  placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>Department</th><td><input type="text" name="depart" placeholder="예)컴퓨터공학부"></td></tr>
			<tr><th>DepartmentNumber</th><td><input type="text" name="departNum" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>PhoneNumber</th><td><input type="text" name="phoneNum" placeholder="***-****-****"></td></tr>
		</table>
		<dl>
			<dd><input type="submit" name="submit" value="보내기"></dd>
			<dd><input type="reset" name="reset" value="다시 작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>