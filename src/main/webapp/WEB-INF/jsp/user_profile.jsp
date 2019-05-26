<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
  <title>Drive Me</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Modal -->
<div id="editUser" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Profile</h4>
      </div>
      <div class="modal-body">
        <form action="/editUser"  method="post">
    <div class="form-group">
      <label for="firstName">First Name:</label>
      <input type="text" class="form-control" id="firstName" value=${User.firstName} placeholder="First Name" name="firstName">
    </div>
    <div class="form-group">
      <label for="lastName">Last Name:</label>
      <input type="text" class="form-control" id="lastName" value=${User.lastName} placeholder="Last Name" name="lastName">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" value=${User.email}  name="email">
    </div>
    <div class="form-group">
      <label for="contactNumber">Contact Number:</label>
      <input type="number" class="form-control" id="contactNumber" value=${User.contatcNumber}  placeholder="Contact Number" name="contatcNumber" >
    </div>
    <div class="form-group">
      <label for="driving_license_number">Driving License Number</label>
      <input type="text" class="form-control"  placeholder="Driving License Number" value=${User.driving_license_number} " id="driving_license_number"  name="driving_license_number">
    </div>
    
    <div class="form-group">
      <label for="usr_name">User Name:</label>
      <input type="text" class="form-control" id="usr_name" value=${User.usr_name} placeholder="User Name" name="usr_name">
    </div>
    <div class="form-group">
      <label for="usr_password">Password</label>
        <input type="hidden" class="form-control"  placeholder="Password"  value =${User.usr_password} id="usr_password"  name="usr_password">
      <input type="text" class="form-control"  placeholder="Enter here if you want to chnage Password"  id="usr_password" >
       
        <input type="hidden" class="form-control"  placeholder="Password" value =${User.userId} id="usr_Id"  name="userId">
    </div>
     
     
     <!-- <h2>Car Details</h2>
     <div class="form-group">
      <label for=firstName>First Name:</label>
      <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName">
    </div> -->
     
    <button type="submit" value="submit" class="btn btn-primary">Submit</button>
  </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> 

<!-- Navbar start -->
<div id="nav-placeholder">
<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/">DriveMe.com</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout">Logout</a></li>
        <li><a href="/findride">Find Ride</a></li>
        <li><a href="/offerride">Offer A Ride</a></li>
        <li><a href="/about">About</a></li>
        <li><a href="#">Contact Us</a></li>
      </ul>
    </div>
  </div>
</nav>

</div>

<div class="container">
  <div class="row">
    <div class="col-sm-3 text-center" style="background-color:#F5F5F5;height:700px">
     <img alt="profile pic" width="100px" style="padding-top: 20px"  src="https://www.freeiconspng.com/uploads/user-icon-png-person-user-profile-icon-20.png">
      <p>${User.firstName} </p>
      <p>${User.lastName}</p>
      <p>${User.contatcNumber} </p>
     <div class="btn-group">
  <a href="/offerride" class="btn btn-danger">Offer Ride</a>
  <a href="/findride" class="btn btn-success">Request Ride</a>
</div>
<br><br><br>
<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#editUser">Edit Profile</button>
 
    </div>
    <div class="col-sm-8"">
     <h3> Your Requested Rides     <small>This is the list of your requested rides:</small> </h3>
  <hr>
  <center>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Date</th>
      <th scope="col">From</th>
      <th scope="col">To</th>
      <th scope="col">Payment</th>
      <th scope="col">Review</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="listValue" items="${rideRequestMapping}">
  <tr>
   <td>${listValue.rideDate}</td>
  <td>${listValue.rideStartPoint}</td>
  <td>${listValue.endPoint}</td>
<td> <c:choose> <c:when test="${listValue.paymentFlag}">
<a class="btn btn-danger" disabled>Paid</a>
</c:when>
<c:otherwise><a class="btn btn-danger" href="payRide?req_id=${listValue.req_id}">Pay Now</a></c:otherwise></c:choose></td>
      <td><c:choose><c:when test="${listValue.reviewFlag}">
<a class="btn btn-primary" disabled>Reviewed</a>
</c:when>
<c:otherwise><a class="btn btn-primary" href="reviewRate?req_id=${listValue.req_id}&rvw_usr=${listValue.offererUserId}">Review</a></c:otherwise></c:choose></td>
        
      
  </tr> 
  </c:forEach>
  </tbody>
</table>
</center>
<h3>Your Offered Ride  <small>This is the list of your offered rides:</small> </h3>
  <hr>
     <center>
  <table class="table">
  <thead>
    <tr>
      <th scope="col">Date</th>
      <th scope="col">From</th>
      <th scope="col">To</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="listValue" items="${offerRideList}">
  <tr>
  <td>${listValue.ride_start_date}</td>
  <td>${listValue.ride_start_point}</td>
  <td>${listValue.ride_end_point}</td>
  </tr> 
  </c:forEach>
  </tbody>
</table>
</center>
       
   
    </div>
  </div>
</div>
    <!-- Footer -->
<footer class="container-fluid bg-4 text-center">
  <p class="love">Made with <span class="glyphicon glyphicon-heart"></span> at UGA</p>
</footer>

</body>

