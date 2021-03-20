<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");

        Enumeration param=request.getParameterNames();
        while(param.hasMoreElements())
        {
            String name=(String)param.nextElement();
            String paramValue=request.getParameter(name);
            out.println(name+" : "+paramValue + "<br>");
        }
        
    %>
</body>
</html>
