package guestbook.exception;

public class IvalidMessagePasswordException extends Exception{

	public IvalidMessagePasswordException() {
		super("비밀번호가 일치하지 않습니다.");
	}
	
	
}
