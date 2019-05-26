<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
  <title>Offer Ride</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
</head>
<body>
<!-- Navbar start -->
<div id="nav-placeholder">
</div>
<script>
	$(function(){
  		$("#nav-placeholder").load("navbar.html");
	});
</script>

<div class="container" style="width:350px">
<h2>${UpdateProfile}</h2>
  <h2>Sign In</h2>
  <form action="/authenticateUserLogin"  method="post">
    <div class="form-group">
      <label for="usr_name">User Name:</label>
      <input type="text" class="form-control" id="usr_name" placeholder="User Name" name="usr_name">
    </div>
    <div class="form-group">
      <label for="usr_password">Password:</label>
      <input type="password" class="form-control" id="usr_password" placeholder="Password" name="usr_password">
    </div>
    <c:if test="${not empty error}">
   Error: ${error}
</c:if>
     
    <button type="submit" value="submit" class="btn btn-primary">Log in</button>
    Not an user? <a href="/createUser">Sign Up now </a>

    
  </form>
</div>
<!-- Footer -->
<br>
<!-- footer start -->
<div id="footer-placeholder">
</div>

<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
  <p class="love">Made with <span class="glyphicon glyphicon-heart"></span> at UGA</p>
</footer>
</script>
</body>
</html>
