package driveme.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import driveme.model.OfferRide;
import driveme.model.User;
import driveme.service.rideServiceImpl;

@Controller
public class findride {
	
/*	@Autowired
	private String ride_start_point;
	
	@Autowired
	private String ride_end_point;
	
	@Autowired
	private String ride_start_date;*/
	
	@Autowired
    private rideServiceImpl rideService;
	

		@RequestMapping("/findride")
		public String findride(HttpServletRequest request, HttpSession session,HttpServletResponse response) {
			if(session.getAttribute("User")==null)
			return "login";
			else
				return "findride";
		}
		@PostMapping("/searchRide")
		public String searchRide(String ride_start_point,String ride_end_point,String ride_start_date,ModelMap map) { 
			
			System.out.println(ride_start_point +ride_end_point+ride_start_date);
			List<OfferRide> offerRideList=rideService.searchRide(ride_start_point, ride_end_point, ride_start_date);
			map.addAttribute("offerRideList",offerRideList);
			map.addAttribute("ride_start_point",ride_start_point);
			map.addAttribute("ride_end_point",ride_end_point);
			map.addAttribute("ride_start_date",ride_start_date);
			return "findride";
			
		}
		
		@RequestMapping(value = "/acceptRide", method = RequestMethod.GET)
		public String acceptRide(@RequestParam("or_id") Long or_id,ModelMap map,HttpServletRequest request, HttpSession session,HttpServletResponse response) { 
			try {
				User user=(User)session.getAttribute("User");
				System.out.println(or_id);
				if(rideService.saveRideRequest(or_id, user.getUserId())) {
					Map<String,Object> mapObject=rideService.userProfile(user);
					session.setAttribute("User", user);
					map.addAttribute("User", user);	
					map.addAttribute("offerRideList",mapObject.get("offerRideList"));
					map.addAttribute("rideRequestMapping",mapObject.get("rideRequestMapping"));
					map.addAttribute("paymentList",mapObject.get("paymentList"));
					map.addAttribute("reviewList",mapObject.get("reviewList"));
					return "user_profile";
				}
				
				
				else
				{
					return "error";
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
				return "error";
			}
			
		}
		
		
}
