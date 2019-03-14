<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/signup.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signup" method="post" action="BookSignupAction" enctype="multipart/form-data">
      <img class="mb-4" src="./images/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
      
      <label for="inputBookName" class="sr-only">BookName</label>
      <input type="text" id="inputBookName" name="inputBookName" class="form-control" placeholder="BookName" required autofocus>
      
      <label for="inputBookAuthor" class="sr-only">BookAuthor</label>
      <input type="text" id="inputBookAuthor" name="inputBookAuthor" class="form-control" placeholder="BookAuthor" required autofocus>
     
      <label for="inputBookPrice" class="sr-only">BookPrice</label>
      <input type="text" id="inputBookPrice" name="inputBookPrice" class="form-control" placeholder="BookPrice" required autofocus>
     
      <label for="inputBookNum" class="sr-only">BookNum</label>
      <input type="text" id="inputBookNum" name="inputBookNum" class="form-control" placeholder="BookNum" required autofocus>
     
      <label for="avatar" class="sr-only">Confirm password</label>
      <input type="file" id="avatar" name="avatar" class="form-control" placeholder="avatar" required>
     
      <label for="introduce" class="sr-only">Confirm password</label>
      <textarea id="introduce" name="introduce" class="form-control" placeholder="Introduce (less than 1000)" rows="5" required></textarea>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      Have signed up? <a href="signin.jsp">Sign in!</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>