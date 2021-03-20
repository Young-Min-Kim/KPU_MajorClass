<%@ page contentType = "text/html; charset=utf-8"%>
<%@ page import="dto.Book" %>
<%@ page import="dao.BookRepository" %>

<%
	request.setCharacterEncoding("UTF-8");
	String bookId = request.getParameter("bookId");
	String name = request.getParameter("name");
	String unitPrice = request.getParameter("unitPrice");
	String description = request.getParameter("description");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String category = request.getParameter("category");
	String unitsInStock = request.getParameter("unitsInStock");
	String totalPages = request.getParameter("totalPages");
	String releaseDate = request.getParameter("releaseDate");
	String condition = request.getParameter("condition");

	Integer price;
	
	if(unitPrice.isEmpty())
		price = 0;
	else
		price = Integer.valueOf(unitPrice);
	
	long stock;
	
	if(unitsInStock.isEmpty())
		stock = 0;
	else
		stock = Long.valueOf(unitsInStock);
	
	/*이걸 추가해주는 이유는 뭘까 -> totl_page로 변환을 안해주면 long으로 선언한 setTotalPages에 들어가지 않기 때문에 
	totalPages는 스트링 타입이고 totl_page는 롱타입이기 때문이다.
	*/
	long totl_page;
	
	if(totalPages.isEmpty())
		totl_page = 0;
	else
		totl_page = Long.valueOf(totalPages);
	
	BookRepository dao = BookRepository.getInstance();
	
	Book newProduct = new Book();
	newProduct.setBookId(bookId);
	newProduct.setName(name);
	newProduct.setUnitPrice(price);
	newProduct.setDescription(description);
	newProduct.setAuthor(author);
	newProduct.setPublisher(publisher);
	newProduct.setCategory(category);
	newProduct.setUnitsInStock(stock);
	newProduct.setTotalPages(totl_page);
	newProduct.setReleaseDate(releaseDate);
	newProduct.setCondition(condition);
	
	dao.addBook(newProduct);
	
	

	response.sendRedirect("products.jsp");
%>