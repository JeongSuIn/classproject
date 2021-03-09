package com.example.board.domain;

public class BoardWriteRequest {
	
	private String userName;
	private String userTitle;
	private String userContents;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	// method 생성
		public Board toBoard() {
			Board board = new Board();
			board.setUser_name(userName);
			board.setTitle(userTitle);
			board.setContents(userContents);
			
			return board;
		}
	
	@Override
	public String toString() {
		return "BoardWriteRequest [userName=" + userName + ", userTitle=" + userTitle + ", userContents=" + userContents
				+ "]";
	}
	
	
	
	
	

}
