package driveme.model;

public class RideReqestMapping {
	
	private Long req_id;
	private Long rr_map_or;
	private Long rr_user_id;
	private String rideDate;
	private String rideStartPoint;
	private String endPoint;
	private String status;
	private Long offererUserId;
	public Long getOffererUserId() {
		return offererUserId;
	}
	public void setOffererUserId(Long offererUserId) {
		this.offererUserId = offererUserId;
	}
	public Long getReq_id() {
		return req_id;
	}
	public void setReq_id(Long req_id) {
		this.req_id = req_id;
	}
	private boolean paymentFlag;
	private boolean reviewFlag;
	
	public String getRideDate() {
		return rideDate;
	}
	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}
	public String getRideStartPoint() {
		return rideStartPoint;
	}
	public void setRideStartPoint(String rideStartPoint) {
		this.rideStartPoint = rideStartPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getRr_map_or() {
		return rr_map_or;
	}
	public void setRr_map_or(Long rr_map_or) {
		this.rr_map_or = rr_map_or;
	}
	public Long getRr_user_id() {
		return rr_user_id;
	}
	public void setRr_user_id(Long rr_user_id) {
		this.rr_user_id = rr_user_id;
	}
	
	
	public boolean isPaymentFlag() {
		return paymentFlag;
	}
	public void setPaymentFlag(boolean paymentFlag) {
		this.paymentFlag = paymentFlag;
	}
	public boolean isReviewFlag() {
		return reviewFlag;
	}
	public void setReviewFlag(boolean reviewFlag) {
		this.reviewFlag = reviewFlag;
	}
	@Override
	public String toString() {
		return "RideReqestMapping [req_id=" + req_id + ", rr_map_or=" + rr_map_or + ", rr_user_id=" + rr_user_id
				+ ", rideDate=" + rideDate + ", rideStartPoint=" + rideStartPoint + ", endPoint=" + endPoint
				+ ", status=" + status + ", offererUserId=" + offererUserId + ", paymentFlag=" + paymentFlag
				+ ", reviewFlag=" + reviewFlag + "]";
	}

	
	
	

}
