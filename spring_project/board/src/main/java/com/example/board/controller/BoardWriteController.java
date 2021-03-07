package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo/wirte")
public class BoardWriteController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getWriteForm() {
		return "writeForm";
	}

}
