package com.example.board.dao;

import java.util.List;
import java.util.Map;

import com.example.board.domain.Board;

public interface BoardDao {
	
	// public abstract 생략
		// 회원 등록
		int insertBoard(Board board);
		
		// 전체 회원의 수
		int BoardCountUpdate();

		// 로그인
		Board selectLogin(String id, String pw);

		// 회원의 총 인원수
		int selectTotalCount();

		// 회원 리스트(페이지 번호에 맞는 회원 리스트 구하기)
		List<Board> selectBoardList(Map<String, Object> param);
		
		// 2021.01.28: Rest API - GET
		List<Board> selectAllBoardList();

		// 검색한 회원의 수
		int selectSearchBoardCount(Map<String, Object> listMap);

		// 회원 정보 삭제
		int deleteBoardByIdx(int idx);

		// 회원 정보 조회 : idx로 조회
		Board selectBoardByIdx(int idx);

		// 회원 정보 update
		int updateBoard(Board Board);

		// id 존재 유무 확인
		int selectBoardByIdCount(String id);
		
		// idx, verify 조건으로 조회
		int selectBoardByIdxVerify(int index);
		
		// 인증처리 verify = 'Y'
		int updateBoardVerify(int idx, String code);

}
