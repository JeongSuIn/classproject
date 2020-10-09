package project;

public class PhoneInfor {
	//변수: 이름, 전화번호, 생년월일
	// 메소드: 적절한 출력이 가능하도록 정의 
	//(생년월일 정보는 저장할 수도 있고, 저장하지 않을 수 도 있게끔 생성자 생성)
	/*
	 	• 이름            name              String
		• 전화번호       phoneNumber     String
		• 생년월일       birthday            String 
	 */
	
	//변수: 이름, 전화번호, 생년월일
	String name;		//이름
	String phoneNumber;	// 전화번호
	String birthday;	// 생일
	
	// 생성자 추가
	PhoneInfor(){ //기본 생성자
		this("이름", "010-xxxx-xxxx", "2020-01-01");
	}

	// 생성자의 오버로딩
	
	// 이름, 생년월일, 생일
	PhoneInfor(String name, String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	// 이름, 생년월일
	PhoneInfor(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	PhoneInfor(PhoneInfor man){
		this(man.name, man.phoneNumber, man.birthday);
	}
	
	
	
	// 출력 메소드	
	void showData() {
		System.out.println("이름: " + name + ", 전화번호: " + phoneNumber + ", 생일: " + birthday);
		
	}
	
	
	// 메인 메소드
	public static void main(String[] args) {
		PhoneInfor man = null;
		
		// 사람1
		man = new PhoneInfor("홍길동", "010-1111-1111" , "2020-01-01");
		
		// 사람 2
		PhoneInfor man2 = new PhoneInfor("일지매", "010-2222-2222", "2020-02-02");
		
		// 사람3
		PhoneInfor man3 = new PhoneInfor("장보고", "010-3333-3333");
		
		// 출력
		System.out.println("사람 1의 정보");
		man.showData();
		System.out.println("-----");
		
		System.out.println("사람2의 정보");
		man2.showData();
		System.out.println("-----");
		
		System.out.println("사람 3의 정보");
		man3.showData();
		System.out.println("-----");
		
	}
	
}
