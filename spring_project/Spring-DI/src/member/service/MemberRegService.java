package member.service;

import member.dao.Dao;

public class MemberRegService implements MemberService{

	//Dao dao = new MemberDao();	// 의존성이 높은 코드 -> 다형성
	private Dao dao;	// 주입받아야하는 참조 변수 
	
	// 생성자를 통해서 Dao타입의 인스턴스를 주입 받는다.
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object process() {
		System.out.println("MemberRegService 실행!");
		
		// 구현체
		dao.insert();	
		
		
		return null;
	}

}
