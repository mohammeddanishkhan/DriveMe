package driveme.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class review {
	
	@RequestMapping("/review")
	public String review() {
		return "review";
		
	}
	
	@RequestMapping(value = "/reviewRate", method = RequestMethod.GET)
	public String ReviewRate(@RequestParam("req_id") Long req_id,@RequestParam("rvw_usr") Long rvw_usr, ModelMap map,HttpServletRequest request, HttpSession session,HttpServletResponse response) {
		
		map.addAttribute("Requester_Id", req_id);
		map.addAttribute("Reviewr_User_Id", rvw_usr);
		return "review";
		
	}
}
