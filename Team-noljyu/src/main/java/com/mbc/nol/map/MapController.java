package com.mbc.nol.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	
	@RequestMapping(value = "/hospital")
	public String hospital() {
		
		return "hospital";
	}
}
