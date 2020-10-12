package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfor pi1 = new PhoneInfor("손흥민", "010-1111-1111", "1990-12-10");
		pi1.showInfor(); // 참조변수 pi1이 가리키는 phoneInfor 타입 객체의 메소드
		
		PhoneInfor pi2 = new PhoneInfor("박지성", "010-2222-2222");
		pi2.showInfor();
	}

}
