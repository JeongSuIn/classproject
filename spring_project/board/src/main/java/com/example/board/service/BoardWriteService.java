package com.example.board.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.dao.BoardDao;
import com.example.board.domain.Board;
import com.example.board.domain.BoardWriteRequest;


@Service
public class BoardWriteService {
	
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Transactional
	public int boardWrite(BoardWriteRequest writeRequest, HttpServletRequest request) {
		
		int result = 0;
		
		File newFile = null;
		String newFileName = null;
		
		String uploadPath="/fileupload/board";
		
		String saveDirPath = request.getSession().getServletContext().getRealPath(uploadPath);
		
		newFileName = writeRequest.getUserName()+System.currentTimeMillis();
		
		newFile = new File(saveDirPath, newFileName);
		
		// 파일 저장
		try {
			
			FileOutputStream thumbnail = new FileOutputStream(new File(saveDirPath, "s_" + newFileName));
			
			// 썸네일 저장
			/*
			 * Thumbnailator.createThumbnail( writeRequest.getUserImage().getInputStream(),
			 * thumbnail, 50, 50);
			 */
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Board board = writeRequest.toBoard();
		if(newFileName != null) {
			board.setImage(newFileName);
		}
		
		try {
			
			dao = template.getMapper(BoardDao.class);
			
			// board count -> boardCount +1
			dao.BoardCountUpdate();
			
			// db insert
			result = dao.insertBoard(board);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// 현재 저장한 파일이 있다면? -> 삭제
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
		}

		return result;
	}
	
}
