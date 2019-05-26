package driveme.model;

public class Review {

	private Long rev_id;
	private Long rvw_usr;//offer_user_id
	private Long rvw_map_rr;
	private Long rvw_star;
	public Long getRev_id() {
		return rev_id;
	}
	public void setRev_id(Long rev_id) {
		this.rev_id = rev_id;
	}
	public Long getRvw_usr() {
		return rvw_usr;
	}
	public void setRvw_usr(Long rvw_usr) {
		this.rvw_usr = rvw_usr;
	}
	public Long getRvw_map_rr() {
		return rvw_map_rr;
	}
	public void setRvw_map_rr(Long rvw_map_rr) {
		this.rvw_map_rr = rvw_map_rr;
	}
	public Long getRvw_star() {
		return rvw_star;
	}
	public void setRvw_star(Long rvw_star) {
		this.rvw_star = rvw_star;
	}
	@Override
	public String toString() {
		return "Review [rev_id=" + rev_id + ", rvw_usr=" + rvw_usr + ", rvw_map_rr=" + rvw_map_rr + ", rvw_star="
				+ rvw_star + "]";
	}
	
	
}
