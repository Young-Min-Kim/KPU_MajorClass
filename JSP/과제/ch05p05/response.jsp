<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
	<%
		Calendar time = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat ("h:mm:ss");
		String format_time = format1.format(time.getTime());
		int ampm = time.get(Calendar.AM_PM);
	%>
<p> 현재 시간은 <% out.println(format_time); %> <%if(ampm==0) out.println("AM"); else out.println("PM");%>
    <%
        response.setIntHeader("Refresh",5);
    %>
   
<p> <a href="./response_data.jsp"> Google 홈페이지로 이동하기</a>
</body>
</html>
