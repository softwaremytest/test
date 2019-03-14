<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${shoppings }" var="shopping">
	<div >
		
			<div style="float: left; margin-top: 8px;">
				<a href="book.jsp?id=${shopping.bookid }">
				<img src="./images/upload/${booksAvatar[shopping.bookid] }" width="64"></a>
			</div>
			<br>
		    <br>
			<div > 
               <br>
		       <br>
               <input type="text" id="inputtime" name="inputtime" 
                 class="form-control" placeholder="加入时间:${shopping.shoptime }" 
                 required autofocus readonly="true">
             	<br>
		        
		   </div>
		   <div class="blog-comment newcontent">
            <form method="post" action="BuyBookAction">
              
              <input type="hidden" id="id" name="id" value="${shopping.bookid}" />
              <button class="btn btn-lg btn-primary" type="submit">Buy</button>
            </form>
            
            </div>
		
	</div>
			<!-- /.blog-post -->
</c:forEach>