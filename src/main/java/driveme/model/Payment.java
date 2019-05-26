package driveme.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Payment {

private Long payment_id;
 private Long amount_paid;
 
 private Long payment_map_rr;

@Override
public String toString() {
	return "Payment [payment_id=" + payment_id + ", amount_paid=" + amount_paid + ", payment_map_rr=" + payment_map_rr
			+ "]";
}

public Long getPayment_id() {
	return payment_id;
}

public void setPayment_id(Long payment_id) {
	this.payment_id = payment_id;
}

public Long getAmount_paid() {
	return amount_paid;
}

public void setAmount_paid(Long amount_paid) {
	this.amount_paid = amount_paid;
}

public Long getPayment_map_rr() {
	return payment_map_rr;
}

public void setPayment_map_rr(Long payment_map_rr) {
	this.payment_map_rr = payment_map_rr;
}
 
 

}
