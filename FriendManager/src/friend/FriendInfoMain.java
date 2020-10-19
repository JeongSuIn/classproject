package friend;

import java.util.Scanner;

public class FriendInfoMain {

	public static void main(String[] args) {
		
		FriendInfoHandler handler = new FriendInfoHandler(10);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("*** 메뉴 선택 ***");
			System.out.println("1. 고교 친구 정보를 저장");
			System.out.println("2. 대학 친구 정보를 저장");
			System.out.println("3. 전체 정보를 출력");
			System.out.println("4. 기본 정보를 출력");
			System.out.println("5. 프로그램 종료");
			System.out.println("선택하세요 >> ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: case 2:
					handler.addFriend(choice);					
					break;
				case 3:
					handler.showAllData();
					break;					
				case 4:
					handler.showAllSimpleData();
					break;					
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return; // 메소드를 종료 -> 메인메소드 안에서 돌고 있으므로 메인 메소드를 종료
					
				
			}
			
		}

	}

}
