package com.aia.op.member.dao;

import java.util.List;

import com.aia.op.member.domain.Member;

public interface MemberDao {
	
	// public abstract 생략
	// 회원 등록
	int insertMember(Member member);
	// 로그인
	Member selectLogin(String id, String pw);
	// 회원의 총 인원수
	int selectTotalCount();
	// 회원 리스트(페이지 번호에 맞는 회원 리스트 구하기)
	List<Member> selectMemberList(int startRow, int cntPerPage);
}
