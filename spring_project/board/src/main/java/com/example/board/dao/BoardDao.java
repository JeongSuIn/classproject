package com.example.board.dao;

import java.util.List;
import java.util.Map;

import com.example.board.domain.Board;

public interface BoardDao {
	
	// public abstract 생략
		// 회원 등록
		int insertBoard(Board board);
		
		// 전체 회원의 수
		int memberCountUpdate();

		// 로그인
		Member selectLogin(String id, String pw);

		// 회원의 총 인원수
		int selectTotalCount();

		// 회원 리스트(페이지 번호에 맞는 회원 리스트 구하기)
//		List<Member> selectMemberList(int startRow, int cntPerPage);
		List<Member> selectMemberList(Map<String, Object> param);
		
		// 2021.01.28: Rest API - GET
		List<Member> selectAllMemberList();

		// 검색한 회원의 수
		int selectSearchMemberCount(Map<String, Object> listMap);

		// 회원 정보 삭제
		int deleteMemberByIdx(int idx);

		// 회원 정보 조회 : idx로 조회
		Member selectMemberByIdx(int idx);

		// 회원 정보 update
		int updateMember(Member member);

		// id 존재 유무 확인
		int selectMemberByIdCount(String id);
		
		// idx, verify 조건으로 조회
		int selectMemberByIdxVerify(int index);
		
		// 인증처리 verify = 'Y'
		int updateMemberVerify(int idx, String code);

}
