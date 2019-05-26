package driveme.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import driveme.model.OfferRide;
import driveme.model.User;
import driveme.service.rideServiceImpl;

@Controller
public class offerride {

	@Autowired
    private rideServiceImpl rideService;
	
		@RequestMapping("/offerride")
		public String offerride(HttpServletRequest request, HttpSession session,HttpServletResponse response) {
			if(session.getAttribute("User")==null)
				return "login";
				else
					return "offerride";
			
			
		}
		
		@PostMapping("/offerride")
		public String offerRideSubmit(OfferRide ride, ModelMap map,HttpServletRequest request, HttpSession session,HttpServletResponse response) {
			try
			{
				
				System.out.println(ride);
				User user=(User)session.getAttribute("User");
				ride.setOr_user_id(user.getUserId());
				rideService.saveOfferRide(ride);
				map.addAttribute("OfferRide", ride);
				map.addAttribute("User",user);
				return "ridedetails";
			}
			
			catch (Exception e) {
				e.printStackTrace();
				return "login";
			}
			
		}
}
