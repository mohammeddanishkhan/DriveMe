<!DOCTYPE html>
<html lang="en">
<head>
  <title>Drive Me</title>
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
<div class"RequesterProfile" style="padding-left: 20px">
 <img alt="profile pic" width="100px" style="padding-top: 20px"  src="https://www.freeiconspng.com/uploads/user-icon-png-person-user-profile-icon-20.png">
      <p>First Name: </p>
      <p>Last Name </p>
      <p> Mobile </p>
     <div class="btn-group">
  <a href="/user_profile" class="btn btn-success">Accept Request</a>
  <a href="/user_profile" class="btn btn-danger">Reject Request</a>
</div> 

</div>
</body>
</html>
