package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService2;
import member.service.MemberRegService2;

public class MemberMain3 {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 생성
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx6.xml");
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx7.xml");
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx8.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx8.xml");
		
		// 2. MemberRegService 객체가 필요
		MemberRegService2 regService = ctx.getBean("memberRegService", MemberRegService2.class);
		
		// 3. MemberRegService -> process() 실행
		regService.process(); // MemberRegService 실행 -> dao.insert() 실행
		
		// 4. MemberInfoService 객체 생성
		MemberInfoService2 infoService = ctx.getBean("memberInfoService", MemberInfoService2.class);
		
		// 5. MemberInfoService -> process() 실행
		infoService.process();

	}

}
