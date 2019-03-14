<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${books }" var="book">
	<div class="blog-post">
		<div>
			<div style="float: left; margin-top: 8px">
				<a href="book.jsp?id=${book.id }">
				<img src="./images/upload/${booksAvatar[book.bookname] }" width="64"></a>
			</div>
			
			<div>
				<a href="book.jsp?id=${book.id }">
						<h2 class="blog-post-title">${book.bookname }</h2></a>
				<p class="blog-post-meta">
					&nbsp;&nbsp; by ${book.bookauthor }</a>.&nbsp;&nbsp; 
					剩余量:${book.num }&nbsp;&nbsp;
					<img src="./images/font-visited.png" height="16">(${book.bv }) 
					
				</p>
                
				<br>
				
			</div>
			<!-- /.blog-post -->
</c:forEach>