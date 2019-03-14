<%@include file="components/header.jsp" %>

    <div class="container">
		<%@include file="components/nav.jsp" %>


    </div>

    <main role="main" class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          
 
          <jsp:include page='${"OrderServlet" }'>
           	<jsp:param name="type" value="listorders"/>
          </jsp:include>
        
          <nav class="blog-pagination">
            <a class="btn btn-outline-primary" href="#">Older</a>
            <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
          </nav>
         
        </div><!-- /.blog-main -->

        <%@include file="components/asidebar.jsp" %>

      </div><!-- /.row -->

    </main><!-- /.container -->
 <%@include file="components/footer.jsp" %>
