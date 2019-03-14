<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10 blog-main">
        <div style="float: left; margin-top: 8px">
           <img src="./images/upload/${booksAvatar[book.bookname] }" width="64">
        </div>
        <div style="float:right; margin-top: 8px"> 
          
          <input type="text" id="inputbookid" name="inputbookid" 
                 class="form-control" placeholder="id:${book.id }" 
                 required autofocus readonly="true">
          <input type="text" id="inputbooknum" name="inputbooknum" 
                 class="form-control" placeholder="剩余量:${book.num }" 
                 required autofocus readonly="true">
        </div>
         
        <div class="blog-post">
         
          <h2 class="blog-post-title">${book.bookname }</h2>
          
          <p class="blog-post-meta">
                       作者:${book.bookauthor }.&nbsp;&nbsp;
            <img src="./images/font-visited.png" height="16">(${book.bv })
            <img src="./images/font-comment.png" height="16">(${booksCommentsCount[book.id] })</p>

          <p>${book.introduce }</p>
        </div>
        <!-- /.blog-post -->
        
          <div class="blog-comment newcontent">
            <form method="post" action="BuyBookAction">
              
              <input type="hidden" id="id" name="id" value="${param.id}" />
              <button class="btn btn-lg btn-primary" type="submit">Buy</button>
            </form>
            <br>
            </div>
            <div>
            <form method="post" action="ShopBookAction">
              
              <input type="hidden" id="id" name="id" value="${param.id}" />
              <button class="btn btn-lg btn-primary" type="submit">加入购物车</button>
            </form>
          </div>
        
        <br>
        <br>
        <div class="blog-post">
          <a class="btn btn-outline-primary" href="index.jsp">Return</a>
          
         
        </div>

      </div>
      <!-- /.blog-main -->

    </div>
    <!-- /.row -->