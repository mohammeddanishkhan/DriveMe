package driveme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import driveme.model.OfferRide;
import driveme.model.Payment;
import driveme.model.Review;
import driveme.model.RideReqestMapping;
import driveme.model.User;


@Repository
public class rideDaoImpl {
	
	
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
    
	public boolean saveUser(User usr) {
		try
		{
			String sqlInset="insert into users (firstName,lastName,email,contatcNumber,driving_license_number,usr_name,usr_password) values(?,?,?,?,?,?,?)";
			jdbcTemplate.update(sqlInset, usr.getFirstName(),usr.getLastName(),usr.getEmail(),usr.getContatcNumber(),usr.getDriving_license_number(),usr.getUsr_name(),usr.getUsr_password());
			if(!(usr.getCar_model().equals("")||usr.getCar_model().isEmpty()||usr.getCar_model()==null)) {
				String sqlCar = "Insert into car(car, car_model, reg_number, owned_by) Values(?, ?, ?, (Select user_id From users Where usr_name = ?))";
				jdbcTemplate.update(sqlCar, usr.getCar_mnfr(), usr.getCar_model(), usr.getReg_no(), usr.getUsr_name());	
			}
			
			return true;	
		}
		catch (Exception e) {
			System.out.println("Exception in saveUser");
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	public User checkUser(String userName, String password) {
		try {
			String sql = "SELECT * FROM USERS WHERE usr_name = ?";
			User user = (User)jdbcTemplate.queryForObject(
					sql, new Object[] { userName }, 
					new BeanPropertyRowMapper(User.class));
			if(user!=null) {
				if(BCrypt.checkpw(password, user.getUsr_password()))
					return user;	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
			return null;
		
	}
	
	public boolean saveOfferRide(OfferRide offerRide ) {
		
		try {
			String sql ="insert into offer_ride(ride_start_date,ride_start_time,ride_start_point,ride_end_point,seats_offer,amountPerSeat,or_user_id,seats_available) values(?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql,offerRide.getRide_start_date(),offerRide.getRide_start_time(),offerRide.getRide_start_point(),offerRide.getRide_end_point(),offerRide.getSeats_offer(),offerRide.getAmountPerSeat(),offerRide.getOr_user_id(),offerRide.getSeats_offer());
			return true;
		}
		catch (Exception e) {
			System.out.println("Error inside saveOfferRide");
			e.printStackTrace();
			return false;
		}
	}
	
	public List<OfferRide> searchRide(String ride_start_point,String ride_end_point,String ride_start_date) {
		String sql="select * from offer_ride where ride_start_point=? and ride_end_point=? and ride_start_date=? and seats_available>0";
		List<OfferRide> offerRideList=jdbcTemplate.query(sql,new BeanPropertyRowMapper(OfferRide.class),ride_start_point,ride_end_point,ride_start_date);
		
		for(OfferRide offerRide:offerRideList) {
			String sql1 = "SELECT * FROM USERS WHERE user_id = ?";
			User user = (User)jdbcTemplate.queryForObject(
					sql1, new Object[] { offerRide.getOr_user_id() }, 
					new BeanPropertyRowMapper(User.class));
			offerRide.setOfferFirstName(user.getFirstName());
			offerRide.setOfferLastName(user.getLastName());
			offerRide.setOfferContatcNumber(user.getContatcNumber());
		}
		return offerRideList;
		
	}
	
	public boolean saveRideRequest(Long rr_map_or, Long rr_user_id) {
		try {

			String sql="insert into ride_request_mapping (rr_map_or,rr_user_id) values(?,?)";
			String sql1="update offer_ride set seats_available=seats_available-1 where or_id=?";
			
			jdbcTemplate.update(sql,rr_map_or,rr_user_id);
			jdbcTemplate.update(sql1,rr_map_or);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Map<String,Object> userProfile(User usr) {
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			String sql="select * from offer_ride where or_user_id=?";
			String sql1="select * from ride_request_mapping where rr_user_id=?";
			String sql2="select * from payment where payment_map_rr IN (:reqId)";
			String sql3="select * from review where rvw_map_rr IN (:reqId)";
			String sql4="select * from offer_ride where or_id in(:rr_map_or_List)";
			List<OfferRide> offerRideList=jdbcTemplate.query(sql,new BeanPropertyRowMapper(OfferRide.class),usr.getUserId());
			List<RideReqestMapping> rideRequestMapping=jdbcTemplate.query(sql1,new BeanPropertyRowMapper(RideReqestMapping.class),usr.getUserId());
			List<Long> reqId=new ArrayList<Long>();
			List<Long> rr_map_or_id_List=new ArrayList<Long>();
			for(RideReqestMapping rideReqMap : rideRequestMapping) {
				reqId.add(rideReqMap.getReq_id());
				rr_map_or_id_List.add(rideReqMap.getRr_map_or());
			}
			
			if(reqId.size()==0) {
				reqId.add(0L);
				rr_map_or_id_List.add(0L);
			}
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("reqId", reqId);
			
			MapSqlParameterSource parameters1 = new MapSqlParameterSource();
			parameters1.addValue("rr_map_or_List", rr_map_or_id_List);
			List<OfferRide> rr_map_or_List=namedJdbcTemplate.query(sql4,parameters1,new RowMapper<OfferRide>() {
                @Override
                public OfferRide mapRow(ResultSet resultSet, int i) throws SQLException {
                    return toOfferRide(resultSet);
                }
            });
			
			List<Payment> paymentList=namedJdbcTemplate.query(sql2,parameters,new RowMapper<Payment>() {
                @Override
                public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
                    return toPayment(resultSet);
                }
            });
			List<Review> reviewList=namedJdbcTemplate.query(sql3, parameters,new RowMapper<Review>() {
                @Override
                public Review mapRow(ResultSet resultSet, int i) throws SQLException {
                    return toReview(resultSet);
                }
            });
			
			for(OfferRide offerRide:rr_map_or_List) {
				for(RideReqestMapping rideReqMap : rideRequestMapping) {
					if(rideReqMap.getRr_map_or().intValue()==offerRide.getOr_id().intValue()) {
						rideReqMap.setEndPoint(offerRide.getRide_end_point());
						rideReqMap.setRideStartPoint(offerRide.getRide_start_point());
						rideReqMap.setRideDate(offerRide.getRide_start_date());
						rideReqMap.setOffererUserId(offerRide.getOr_user_id());
					}
				}
			}
			
			for(RideReqestMapping rideReqMap : rideRequestMapping) {
				for(OfferRide offerRide:rr_map_or_List) {
					if(rideReqMap.getRr_map_or().intValue()==offerRide.getOr_id().intValue()) {
						rideReqMap.setEndPoint(offerRide.getRide_end_point());
						rideReqMap.setRideStartPoint(offerRide.getRide_start_point());
						rideReqMap.setRideDate(offerRide.getRide_start_date());
						rideReqMap.setOffererUserId(offerRide.getOr_user_id());
					}
				}
				for(Payment payment:paymentList) {
					if(rideReqMap.getReq_id().intValue()==payment.getPayment_map_rr()) {
						rideReqMap.setPaymentFlag(true);
					}
				}
				for(Review review:reviewList) {
					if(rideReqMap.getReq_id().intValue()==review.getRvw_map_rr()) {
						rideReqMap.setReviewFlag(true);
					}
				}
			}
			map.put("offerRideList", offerRideList);
			map.put("rideRequestMapping", rideRequestMapping);
			map.put("paymentList", paymentList);
			map.put("reviewList", reviewList);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return map;
		
	}
	
	  private Payment toPayment(ResultSet resultSet) throws SQLException {
		  Payment payment = new Payment();
		  payment.setPayment_id(resultSet.getLong("payment_id"));
		  payment.setAmount_paid(resultSet.getLong("amount_paid"));
		  payment.setPayment_map_rr(resultSet.getLong("payment_map_rr"));
	      return payment;
	  }
	  
	  private Review toReview(ResultSet resultSet) throws SQLException {
		  Review review = new Review();
		  review.setRev_id(resultSet.getLong("rev_id"));
		  review.setRvw_map_rr(resultSet.getLong("rvw_map_rr"));
		  review.setRvw_star(resultSet.getLong("rvw_star"));
		  review.setRvw_usr(resultSet.getLong("rvw_usr"));
	      return review;
	  }
	  
	  private OfferRide toOfferRide(ResultSet resultSet) throws SQLException {
		  OfferRide offerRide = new OfferRide();
		  offerRide.setOr_id(resultSet.getLong("or_id"));
		  offerRide.setOr_user_id(resultSet.getLong("or_user_id"));
		  offerRide.setRide_start_date(resultSet.getString("ride_start_date"));
		  offerRide.setRide_start_point(resultSet.getString("ride_start_point"));
		  offerRide.setRide_end_point(resultSet.getString("ride_end_point"));
		  
	      return offerRide;
	  }
	  
		public boolean savePaymentInformation(Payment payment) {
			try {
				String sql ="INSERT INTO payment(payment_map_rr, amount_paid) values(?,?)";
				jdbcTemplate.update(sql,payment.getPayment_map_rr(),payment.getAmount_paid());
				System.out.println("Here n save payment");
				System.out.println(payment.getAmount_paid());
				System.out.println(payment.getPayment_id());
				return true;
			}
			catch (Exception e) {
				System.out.println("Error inside saveOfferRide");
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean saveReviewInformation(Review review) {
			try {
				String sql ="INSERT INTO review(rvw_usr, rvw_map_rr, rvw_star) values(?,?,?)";
				jdbcTemplate.update(sql,review.getRvw_usr(),review.getRvw_map_rr(),review.getRvw_star());
				System.out.println("Here n save review dao");
				
				return true;
			}
			catch (Exception e) {
				System.out.println("Error inside saveReview");
				e.printStackTrace();
				return false;
			}
		}

		public boolean updateUser(User usr) {
			// TODO Auto-generated method stub
			try
			{
				String sqlUpdate="update users SET firstName = ?, lastName = ? ,email = ? ,contatcNumber = ? ,driving_license_number = ? ,usr_name = ? ,usr_password = ? WHERE user_id = ?  ";
				jdbcTemplate.update(sqlUpdate, usr.getFirstName(),usr.getLastName(),usr.getEmail(),usr.getContatcNumber(),usr.getDriving_license_number(),usr.getUsr_name(),usr.getUsr_password(),usr.getUserId());
				return true;	
			}
			catch (Exception e) {
				System.out.println("Exception in editUser");
				e.printStackTrace();
				
			}
			return false;

		}

}
