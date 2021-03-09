package com.example.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board.domain.BoardWriteRequest;
import com.example.board.service.BoardWriteService;

@Controller
@RequestMapping("/board/wirte")
public class BoardWriteController {
	
	@Autowired
	private BoardWriteService writeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getWriteForm() {
		return "board/wirteForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberReg(
			@ModelAttribute("writeData") BoardWriteRequest wRequest,
			HttpServletRequest request,
			Model model
			) {
		
		System.out.println(wRequest);
		int result = writeService.boardWrite(wRequest, request);
		
		model.addAttribute("result", result);
		
		return "board/boardWriteRegView";
	}
	
}
