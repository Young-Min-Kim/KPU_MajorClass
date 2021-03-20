<%@ page contentType = "text/html; charset=utf-8"%>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
<body>
	<%@ include file ="header.jsp" %>
	현재시간 : <%= java.util.Calendar.getInstance().getTime() %>
</body>
</html>