package com.example.board.domain;

public class Board {
	
	private int idx;
	private String user_name;
	private String password;
	private String title;
	private String contents;
	private String image;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	/*
	 * public LoginInfo toLoginInfo() { return new LoginInfo(password) }
	 */
	
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", user_name=" + user_name + ", password=" + password + ", title=" + title
				+ ", contents=" + contents + ", image=" + image + "]";
	}
	
	
	

}
