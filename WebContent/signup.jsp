
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
    <form class="form-signup" method="post" action="SignupAction" enctype="multipart/form-data">
      <img class="mb-4" src="./images/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
      
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required>
      
      <label for="confirmPassword" class="sr-only">Confirm password</label>
      <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm password" required>
      
      <label for="gender" class="sr-only">Gender</label>
      <select id="gender" name="gender" class="form-control" required>
        <option value="f">Female</option>
        <option value="m">Male</option>
        <option value="x">Not sure</option>
      </select>
      
      <label for="avatar" class="sr-only">Confirm password</label>
      <input type="file" id="avatar" name="avatar" class="form-control" placeholder="avatar" required>
      
      
<br/>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      Have signed up? <a href="signin.html">Sign in!</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
