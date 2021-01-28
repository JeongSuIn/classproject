package com.aia.op.member.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.op.member.domain.Member;
import com.aia.op.member.service.MemberListService;

@RestController
@RequestMapping("/rest/ver1/members")
public class MemberRestController {
	
	@Autowired
	private MemberListService listService;
	
	// List 반환 - GET
	@GetMapping
	public List<Member> getMemberList(){
			
		return listService.getListView();
		
	}
	
	
	// 1개의 회원 정보(Member)를 반환 - GET
	
	
	// 회원 정보 저장
	
	
	// 회원 정보 수정
	
	
	// 회원 정보 삭제
	
	
	// 회원 존재 유무 -> 회원 가입 시 중복 체크&db를 분할하면서 외래키 설정을 못해서 회원의 데이터를 입력해도 되는지 확인하기 위해

}
