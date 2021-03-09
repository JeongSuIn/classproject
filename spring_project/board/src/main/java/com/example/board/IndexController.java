package com.example.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.Board;
import com.example.board.service.BoardListService;
import com.example.board.service.BoardWriteService;

@RestController 
public class IndexController {
	
	@Autowired
	private BoardWriteService s;
	
	@Autowired
	private BoardListService listService;
	
	@GetMapping("/")
	public String getIndex() {
		return "index"; // 응답하고자하는 text문자열
	}
	
		
	@RequestMapping(value="/board/wirte", method=RequestMethod.GET)
    public String list() {
        return "board/wirteForm";
    }
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<Board> boardList() {
		return listService.getBoardList();
	}
	
}
