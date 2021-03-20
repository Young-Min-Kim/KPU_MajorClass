<%@ page contentType = "text/html; charset=utf-8"%>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<jsp:useBean id="bean" class="Ch04.com.dao.GuGuDan" />
	<%String result;
	result = bean.process(5);
	out.println(result);
	%>
</body>
</html>