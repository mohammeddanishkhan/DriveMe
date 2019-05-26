package driveme.model;

public class OfferRide {
	
	private Long or_id;
	public Long getOr_id() {
		return or_id;
	}
	public void setOr_id(Long or_id) {
		this.or_id = or_id;
	}
	private String ride_start_point;
	private String ride_end_point;
	private String ride_start_date;
	private String ride_start_time;
	private Long seats_offer;
	private Long or_user_id;
	private Long amountPerSeat;
	private String offerFirstName;
	private String offerLastName;
	private String offerContatcNumber;
	private String status;
	private Long seats_available;
	
	public Long getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(Long seats_available) {
		this.seats_available = seats_available;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOfferFirstName() {
		return offerFirstName;
	}
	public void setOfferFirstName(String offerFirstName) {
		this.offerFirstName = offerFirstName;
	}
	public String getOfferLastName() {
		return offerLastName;
	}
	public void setOfferLastName(String offerLastName) {
		this.offerLastName = offerLastName;
	}
	public String getOfferContatcNumber() {
		return offerContatcNumber;
	}
	public void setOfferContatcNumber(String offerContatcNumber) {
		this.offerContatcNumber = offerContatcNumber;
	}
	public Long getAmountPerSeat() {
		return amountPerSeat;
	}
	public void setAmountPerSeat(Long amountPerSeat) {
		this.amountPerSeat = amountPerSeat;
	}
	public String getRide_start_point() {
		return ride_start_point;
	}
	public void setRide_start_point(String ride_start_point) {
		this.ride_start_point = ride_start_point;
	}
	public String getRide_end_point() {
		return ride_end_point;
	}
	public void setRide_end_point(String ride_end_point) {
		this.ride_end_point = ride_end_point;
	}
	
	public String getRide_start_date() {
		return ride_start_date;
	}
	public void setRide_start_date(String ride_start_date) {
		this.ride_start_date = ride_start_date;
	}
	public String getRide_start_time() {
		return ride_start_time;
	}
	public void setRide_start_time(String ride_start_time) {
		this.ride_start_time = ride_start_time;
	}
	public Long getSeats_offer() {
		return seats_offer;
	}
	public void setSeats_offer(Long seats_offer) {
		this.seats_offer = seats_offer;
	}
	public Long getOr_user_id() {
		return or_user_id;
	}
	public void setOr_user_id(Long or_user_id) {
		this.or_user_id = or_user_id;
	}
	@Override
	public String toString() {
		return "OfferRide [or_id=" + or_id + ", ride_start_point=" + ride_start_point + ", ride_end_point="
				+ ride_end_point + ", ride_start_date=" + ride_start_date + ", ride_start_time=" + ride_start_time
				+ ", seats_offer=" + seats_offer + ", or_user_id=" + or_user_id + ", amountPerSeat=" + amountPerSeat
				+ ", offerFirstName=" + offerFirstName + ", offerLastName=" + offerLastName + ", offerContatcNumber="
				+ offerContatcNumber + ", status=" + status + ", seats_available=" + seats_available + "]";
	}



	

	
	
	
}
