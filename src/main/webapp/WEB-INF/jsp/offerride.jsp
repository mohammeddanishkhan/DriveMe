<!DOCTYPE html>
<html lang="en">

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
<div class="container">
  <h2>Offer Ride</h2>
  <form action="/offerride"  method="post">
    <div class="form-group">
      <label for="ride_start_point">Start Location:</label>
      <input type="text" class="form-control" id="ride_start_point" placeholder="Enter the Start location" name="ride_start_point">
    </div>
    <div class="form-group">
      <label for="ride_end_point">End Location:</label>
      <input type="text" class="form-control" id="ride_end_point" placeholder="Enter End Location" name="ride_end_point">
    </div>
    <div class="form-group">
      <label for="ride_start_date">Date:</label>
      <input type="date" class="form-control" id="ride_start_date"  min="2018-11-28" max="2020-08-26"   name="ride_start_date">
    </div>
    <div class="form-group">
      <label for="ride_start_time">Start Time:</label>
      <input type="time" class="form-control" id="ride_start_time"  name="ride_start_time">
    </div>
    <div class="form-group">
      <label for="seats_offer">Capacity</label>
      <input type="number" class="form-control"  placeholder="Enter Capacity" id="seats_offer"  name="seats_offer">
    </div>
     <div class="form-group">
      <label for="seats_available"></label>
      <input type="hidden" class="form-control"  placeholder="Seats Avilable" id="seats_available"  name="seats_available">
    </div>
    
    <div class="form-group">
      <label for="amountPerSeat">Estimated Amount</label>
      <input type="number" class="form-control"  placeholder="Amount per seat" id="amountPerSeat"  name="amountPerSeat">
    </div>
  
    <button type="submit" value="submit" class="btn btn-primary">Submit</button>
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
