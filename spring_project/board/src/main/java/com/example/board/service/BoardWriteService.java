package com.example.board.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.BoardDao;
import com.example.board.domain.Board;
import com.example.board.domain.BoardWriteRequest;

@Service
public class BoardWriteService {
	
	@Autowired
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	

	public int boardWrite(BoardWriteRequest wRequest, HttpServletRequest request) {
		
		int result = 0;
		
		Board board = wRequest.toBoard();
		System.out.println(board);
		
		try {
			dao = template.getMapper(BoardDao.class);
			
			result = dao.insertBoard(board);
			
			System.out.println("board: " + board);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
}
