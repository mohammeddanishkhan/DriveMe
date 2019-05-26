<!DOCTYPE html>
<html lang="en">

<head>
  <title>Rate the Ride</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
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
<body>
<h1>Rate the Ride</h1>

<form style="padding-left:50px;" method="post" action="/saveReview">
<img src="https://i.dailymail.co.uk/i/pix/2016/12/20/17/3B8B8ED800000578-4052338-image-a-1_1482253605070.jpg" width="250px">
<div class="radio">
  <label><input type="radio" value="1" name="rvw_star">1 Bad</label>
</div>
<div class="radio">
  <label><input type="radio" value="2" name="rvw_star">2 Not Good</label>
</div>
<div class="radio">
  <label><input type="radio" value="3" name="rvw_star">3 Good</label>
</div>
<div class="radio">
  <label><input type="radio" value="4" name="rvw_star">4 Very Good</label>
</div>
<div class="radio">
  <label><input type="radio" value="5" name="rvw_star">5 Excellent</label>
</div>
<input type="hidden" value=${Reviewr_User_Id} name="rvw_usr">
<input type="hidden" value=${Requester_Id} name="rvw_map_rr">


<button type="submit" value="submit" class="btn btn-primary">Submit</button>
  
</form>
<br><br>
    <!-- Footer -->
<footer class="container-fluid bg-4 text-center">
  <p class="love">Made with <span class="glyphicon glyphicon-heart"></span> at UGA</p>
</footer>

</body>

