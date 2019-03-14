<%@include file="components/header.jsp" %>

  <div class="container">
    <%@include file="components/nav.jsp" %>

  </div>
  <br>

<main role="main" class="container">
 <jsp:include page='${"BookServlet"}'>
	<jsp:param value="listbook" name="type" />
	<jsp:param value="${param.id }" name="id" />
 </jsp:include> 
 <jsp:include page='${"BookServlet"}'>
	<jsp:param value="listcomments" name="type" />
	<jsp:param value="${param.id }" name="id" />
 </jsp:include>

  </main>
  <!-- /.container -->
   <%@include file="components/footer.jsp" %>