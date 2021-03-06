package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class IndexController {
	
	@GetMapping("/")
	public String getIndex() {
		return "Index Page"; // 응답하고자하는 text문자열
	}
}
