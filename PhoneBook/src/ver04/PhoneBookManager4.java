package ver04;

import java.util.Scanner;

public class PhoneBookManager4 {
//	 배열: 전화번호 정보(이름, 전화번호, 생일)를 저장하는 목적
	
	// 사용자로부터 데이터를 받는다.
	Scanner sc = new Scanner(System.in);
	
//	Util3.sc.nextLine();
//	new PhoneBookManager3;
	
	// 정보 저장을 위한 배열선언
	private PhoneInfor4[] phoneBook; 
	private int cnt = 0; 			// 저장된 정보의 개수, 배열의 요소 추가 시 인덱스로 사용
	//Scanner sc; //5
	
	public int getCnt() {
		return cnt;
	}
		
	// 초기화(생성자 이용)
	public PhoneBookManager4(int num){
		phoneBook = new PhoneInfor4[num];
		cnt = 0;
	}
	
	// 배열에 친구 정보를 저장하는 기능
	void insertMemberInfo(PhoneInfor4 p) {
		phoneBook[cnt++] = p;
	}
	
	
	// 기능: 1. 저장, 2. 검색, 3. 삭제 
	
//	1.2. 저장 기능 
	// 사용자로부터 데이터를 받아 ->	
	// 인스턴스를 생성 -> 
	// 배열에 생성된 인스턴스의 참조값을 저장: 저장 index는 -> cnt를 이용 -> 저장 후에는 cnt++ 처리
	
	void insertMember(int choice) {  
		System.out.println("정보 입력을 시작합니다.\n");
		
		// 이름 입력 받기 
		System.out.println("이름 >> ");
		String name = sc.nextLine();		
		
		// 전화번호 받기
		System.out.println("전화번호 >> ");
		String phoneNumber = sc.nextLine();		
		
		// 주소 받기
		System.out.println("주소 >> ");
		String address = sc.nextLine();
		
		// 이메일 주소 받기
		System.out.println("이메일 주소 >> " );
		String email = sc.nextLine();
		
		// 인스턴스를 생성해서 저장
		// 인스턴스 생성: 대학 친구와 회사친구가 다르다.
		if(choice==1) {
		//대학 친구 데이터를 받고 -> 인스턴스 생성 -> 배열에 저장
			System.out.println("전공 >> ");
			String major = sc.nextLine();
			
			System.out.println("학년 >> ");
			String year = sc.nextLine();
			insertMemberInfo(new PhoneUnivInfor4(name, phoneNumber, address, email, major, year)); // 데이터를 받는 인스턴스
			
			
		} else if(choice==2) {
			// 회사 동료 데이터를 받고 -> 인스턴스 생성 -< 배열에 저장
			System.out.println("회사명 >> ");
			String company = sc.nextLine();
			insertMemberInfo(new PhoneCompanyInfor(name, phoneNumber, address, email, company)); // 데이터를 받는 인스턴스
		}	
		
		
	}
	
//	3.검색 기능
	// 배열에서 찾는다 -> index를 먼저 찾아야 한다.
	// 검색하고자 하는 이름을 사용자로부터 받고 
	// 배열의 요소(참조 값 -> 인스턴스 참조) PhoneInfor.name 변수의 값과 검색 이름을 비교(동등 비교)		
	// 해당 index를 찾을 수 있다.
	// 검색된 인덱스로 정보를 출력
	
	void searchMember() {
		
		if(cnt==0) {
			System.out.println("저장된 데이터가 없습니다. 다시 메뉴로 이동합니다.");
			return; // 메소드의 종료
		}
			
		// 찾고자 하는 이름을 받는다.
		System.out.println("정보 검색을 시작합니다.");
		System.out.println("찾고자 하는 이름을 입력해주세요 >> ");
		String name = sc.nextLine();
		
		//이름을 요소 index 검색
		//int index = -1;
		int index = searchIndex(name);
		
		
		
		// 검색: index를 찾는다 -> 반복
//		for(int i=0; i<cnt; i++) {
//			if(phoneBook[i].name.equals(name)) {		// phoneBook-> phoneInfor 타입의  참조변수
//			// 찾고자 하는 이름을 값으로 넣어서 논리값을 가져옴.
//			index = i;
//			break;
//			}
//		}
		
		
		if(index<0) { // 
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
		} else {
			// 정보의 출력
			phoneBook[index].showInfor();
		}		
	}
	
	//	이름 문자열을 받아서,
	// 배열의 정보와 비교하고, 
	// index를 찾아서 반환하는 메소드
	int searchIndex(String name) {
		int result = -1;
		
		// 검색: index를 찾는다 -> 반복
		for(int i=0; i<cnt; i++) {
			if(phoneBook[i].name.equals(name)) {		// phoneBook-> phoneInfor 타입의  참조변수
			// 찾고자 하는 이름을 값으로 넣어서 논리값을 가져옴.
			result = i;
			break;
			}
			
		}	
		
		return result;
	}
	
	
	
	
	
//	4.정보 삭제
	// 삭제하고자 하는 이름을 사용자로부터 받는다 -> 
	// 배열에서 이름으로 검색해서 index를 찾는다.
	// 배열에서 찾은 index의 참조값을 삭제: 인스턴스는 찹조하는 참조 변수가 없으면 삭제된다.
	// 참조값에 null을 입력하거나, 다른 주소값을 입력 -> 이전에 있던 참조값은 없어진다.
	// 삭제대상의 index 부터 왼쪽으로 값을 shift 처리 	
	// cnt-1 
	void deleteMember() {
		
		System.out.println("정보 삭제를 진행합니다.");
		System.out.println("삭제 하고자 하는 정보의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		//이름을 요소 index 검색
			int index = -1;
				
			// 검색: index를 찾는다 -> 반복
			for(int i=0; i<cnt; i++) {
				if(phoneBook[i].name.equals(name)) {		// phoneBook-> phoneInfor 타입의  참조변수
				// 찾고자 하는 이름을 값으로 넣어서 논리값을 가져옴.
				index = i;
				break;
				}
			}
				
			if(index<0) {
				System.out.println("삭제 하고자 하는 정보가 존재하지 않습니다.");
			} else {
				// 삭제 처리 진행: 삭제해야 하는 index부터 왼쪽으로 shift 처리
				// index = 3;
				// phoneBook[3] = phoneBook[4];
				// phoneBook[4] = phoneBook[5];
					
				for(int i=index; i<cnt-1; i++) {
					phoneBook[i] = phoneBook[i+1];
				}
					
				cnt--;
					
				System.out.println("정보를 삭제했습니다.");
			}
			 	
		
	}
	// 5.전체 정보 출력
	void displayAll() {
		if(cnt==0 ) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		
		System.out.println("전체 정보를 출력합니다.("+cnt+")");
		System.out.println("-------------------");
		
		for(int i=0; i<cnt; i++) {
			phoneBook[i].showInfor();
			System.out.println("-------------------");
		}
		
	}
}
