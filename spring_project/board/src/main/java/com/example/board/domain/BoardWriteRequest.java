package com.example.board.domain;

import org.springframework.web.multipart.MultipartFile;

public class BoardWriteRequest {
	
	private String userName;
	private String pw;
	private String userTitle;
	private String userContents;
	private MultipartFile userImage;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public String getUserContents() {
		return userContents;
	}
	public void setUserContents(String userContents) {
		this.userContents = userContents;
	}
	public MultipartFile getUserImage() {
		return userImage;
	}
	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
	}
	
	// method
	public Board toBoard() {
		Board board = new Board();
		board.setUser_name(userName);
		board.setPassword(pw);
		board.setTitle(userTitle);
		board.setContents(userContents);
		
		return board;
	}
	
	@Override
	public String toString() {
		return "BoardWriteRequest [userName=" + userName + ", pw=" + pw + ", userTitle=" + userTitle + ", userContents="
				+ userContents + ", userImage=" + userImage + "]";
	}
	
	
	
	

}
