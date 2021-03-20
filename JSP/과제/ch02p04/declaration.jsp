<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
	<%!String data = "Hello, Java Server Pages";
	String getString(){
		return data;
	}
	%>
	<%
		out.println(getString());
	%>
</body>
</html>