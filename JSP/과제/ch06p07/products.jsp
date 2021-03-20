<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.BookRepository" %>
<html>
<head>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Welcome</title>

</head>    
<body>
 
<jsp:include page="menu.jsp"/>
 
<%! String greeting="도서 목록";%>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">
        <%=greeting %>
        </h1>
    </div>
</div>
<%
	BookRepository dao = BookRepository.getInstance();
	ArrayList<Book> listOfBooks=dao.getAllProducts(); 
%>
<div class="container">
        <div class="col" align="L">
            <%
            	for(int i=0;i<listOfBooks.size();i++){
                Book book=listOfBooks.get(i);
            %>
            <div class="col-lg">
                <h4>[<%=book.getCategory() %>] <%=book.getName() %></h4>
                <div style="float: right">
                	<a href="./product.jsp?id=<%=book.getBookId() %>" class="btn btn-secondary rold="button">상세 정보 &raquo</a>
                </div>
                <div>
                	<p><%=book.getDescription()%></p>
                </div>
                
                <p><%=book.getAuthor() %> | <%=book.getPublisher() %> | <%=book.getUnitPrice() %>원</p>
            </div>
            <hr>
            <%}%>
        </div> 
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>