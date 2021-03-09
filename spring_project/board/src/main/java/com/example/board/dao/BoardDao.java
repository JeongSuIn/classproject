package com.example.board.dao;

import java.util.List;

import com.example.board.domain.Board;

public interface BoardDao {
	
	// 게시물 등록
	int insertBoard(Board board);
	
	// 전체 게시물의 수 업데이트
	int boardCountUpdate();

	// 게시물의 총 개수
	int selectTotalCount();
	
	// 게시물리스트
	List<Board> selectBoardList();

	
}
