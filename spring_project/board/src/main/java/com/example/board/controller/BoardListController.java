package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.service.BoardListService;

@Controller
public class BoardListController {
	
	@Autowired
	private BoardListService listService;
	
	@RequestMapping("/board/list")
	public String getboardList(Model model) {
		model.addAttribute("listView", listService.getBoardList());
		model.addAttribute("boardCnt", listService.getBoardTotalCount());
		
		return "board/list";
	}

}
