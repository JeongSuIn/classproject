package ver04;

public class PhoneInfor4 {
	
	//변수: 이름, 전화번호, 생년월일
	// 메소드: 적절한 출력이 가능하도록 정의 
	//(생년월일 정보는 저장할 수도 있고, 저장하지 않을 수 도 있게끔 생성자 생성)
	
	/*
	 	• 이름            name              String
		• 전화번호       phoneNumber     String
		• 생년월일       birthday            String 
	 */
	
	// 변수 설정
	String name;		// 친구의 이름
	String phoneNumber;	// 전화번호	
	String address;		// 주소
	String email;		// 이메일
	
	// 생성자: 3개의 데이터를 받아 초기화
	PhoneInfor4(String name, String phoneNumber, String address, String email){
		this.name = name; // this는 자신을 가리킴
		this.phoneNumber = phoneNumber;		
		this.address = address;
		this.email = email;
	}	
	
	// 변수를 다른 클래스에서도 사용할 수 있도록 하는 코드
	
	
	
	// 저장된 데이터의 적절한 출력 메소드
	void showInfor() {
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("주소: " + address );
		System.out.println("이메일: " + email);			
		
	}
	

}
