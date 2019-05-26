package driveme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class acceptReject {
	@RequestMapping("/acceptReject")
	public String acceptRejectHandler() {
		return "acceptReject";
		
	}
	

}
