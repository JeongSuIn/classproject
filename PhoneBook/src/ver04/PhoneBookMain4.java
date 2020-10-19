package ver04;

import java.util.Scanner;

public class PhoneBookMain4 {

	public static void main(String[] args) {
		
		// PhoneBookManager 인스턴스 생성 -> 배열과 메소드를 사용 // 1 - 인스턴스가 생성
		PhoneBookManager4 manager = new PhoneBookManager4(10);
		System.out.println("현재 저장된 정보의 개수: " + manager.getCnt());
		//System.out.println("저장이 가능한 정보의 총 개수: " + manager.phoneBook.length ); // 배열의 사이즈 
		
		Scanner sc = new Scanner(System.in);
		
		
		
		// 흐름 반복하기
		while(true) {
			
			System.out.println("-----전화번호 관리 프로그램-----");
			System.out.println("메뉴를 입력하세요.");
			System.out.println(" 1. 대학 동기 정보 저장");
			System.out.println(" 2. 회사 동료 정보 저장");			
			System.out.println(" 3. 정보 검색");
			System.out.println(" 4. 정보 삭제");
			System.out.println(" 5. 전체 출력");
			System.out.println(" 6. 프로그램 종료");			
			System.out.println("-------------------------");
			System.out.println(" 선택하세요 >> ");
			
			
			// choice 변수 생성
			int choice = sc.nextInt();
			
			
			// 분기
			switch(choice) {			
				case 1: case 2:
					manager.insertMember(choice);
					System.out.println("현재 저장된 정보의 개수: " + manager.getCnt());
					break;
				case 3:
					manager.searchMember();
					break;
				case 4:
					manager.deleteMember();
					break;
				case 5:
					manager.displayAll();
					break;
				case 6:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
			
			
//			정보 저장 기능 메소드 호출
			//manager.insertMember();  
			
			//System.out.println("현재 저장된 정보의 개수: " + manager.cnt);
			//manager.phoneBook[0].showInfor(); // phoneBook -> phoneIfor타입의 참조변수 -> showInfor 메소드를 호출 가능
		
//			검색 기능 메소드 호출
			//manager.searchMember();
			
		}
		
	
		
	}

}
