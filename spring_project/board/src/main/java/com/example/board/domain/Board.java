package com.example.board.domain;

public class Board {
	
	private int idx;
	private String user_name;
	private String title;
	private String contents;
	
	
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
	
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", user_name=" + user_name + ", title=" + title + ", contents=" + contents + "]";
	}

	
	
	
}
