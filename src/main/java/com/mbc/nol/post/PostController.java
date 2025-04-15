package com.mbc.nol.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {

	
	@RequestMapping(value = "/postinput")
	public String postinput() {
		
		return"postinput";
	}
	
	@RequestMapping(value = "/postout")
	public String postout() {
		
		return "postout";
	}
}
