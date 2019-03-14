<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${orders }" var="order">
	<div >
		
			<div style="float: left; margin-top: 8px;">
				<a href="book.jsp?id=${order.bookid }">
				<img src="./images/upload/${booksAvatar[order.bookid] }" width="64"></a>
			</div>
			<br>
		    <br>
			<div > 
               <br>
		       <br>
               <input type="text" id="inputtime" name="inputtime" 
                 class="form-control" placeholder="购买时间:${order.purchtime }" 
                 required autofocus readonly="true">
             	<br>
		        
		   </div>
		   <div class="blog-comment newcontent">
            <form method="post" action="DeleteOrderAction">
              
              <input type="hidden" id="id" name="id" value="${order.orderid}" />
              <button class="btn btn-lg btn-primary" type="submit">删除</button>
            </form>
            <br>
            </div>
	</div>
			<!-- /.blog-post -->
</c:forEach>