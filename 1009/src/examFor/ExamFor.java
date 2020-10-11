package examFor;

public class ExamFor {

	public static void main(String[] args) {
//		문제 1 int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
		System.out.println("-----문제01-----");
		int x = 11;
		if(x>10 && x<20) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
//		문제 2 char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
		System.out.println("-----문제02-----");
		char ch = 'a';
		if(!(ch ==' ' || ch == '\t')) {
			System.out.println("true");
		} else {
			System.out.println("false");
			
		}
		
		
//		문제 3 char형 변수 ch가 ‘x' 또는 ’X'일 때 true인 조건식		 
		System.out.println("-----문제03-----");
		ch = 'x';
		if(ch=='x' || ch=='X') {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		
//		문제 4 char형 변수 ch가 숫자('0'~'9')일 때, true인 조건식
		System.out.println("-----문제04-----");
		ch = 'a';
		if(ch>='0' && ch<='9') {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		
//		문제 5 char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
		System.out.println("-----문제05-----");
		ch = 'a';
		if((ch>='a'&& ch<='z') || (ch>='A' && ch<='Z')) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		
//		문제 6  int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로나눠떨어지지않을 때 true인 조건식
		System.out.println("-----문제06-----");
		int year = 400;
		if((year%400==0)||(year%4==0 && year%100!=0)) {
			System.out.println("true");		
		} else {
			System.out.println("false");
		}
		

//		문제 7 boolean형 변수 powerOn가 false일 때 true인 조건식
		System.out.println("-----문제07-----");
		
		boolean powerOn = false;
		if(powerOn = false) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

//		문제 8 문자열 참조변수 str이 “yes”일 때 true인 조건식
		System.out.println("-----문제08-----");	
		String str = "yes";
		if(str == "yes") {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
//		문제 [2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오
		System.out.println("-----문제[2]-----");	
		
		int sum = 0; 
		for(int i=1; i<=20; i++) {
			if(!(i%2==0) || !(i%3==0)) {
				sum += i;
				System.out.println("i: " + i + ", sum:" +sum);
			} 
		}
		
//		문제[3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.
		System.out.println("-----문제[3]-----");
		
		sum = 0;
		int result = 0;
		for(int i=1; i<10; i++) {
			sum += i;
			result += sum;
		} System.out.println("result: " + result);
		 
//		문제[4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 
		//몇까지 더해야 총합이 100이상이되는지 구하시오.
		System.out.println("-----문제[4]-----");	
		/*
		 * int i = 1; sum = 0; int Hnum = 0; int Jnum = 0; while(i>0) { i++; if(i%2==0)
		 * { Jnum = -i; System.out.println("Jnum:" + Jnum); } else { Hnum = i;
		 * System.out.println("Hnum:" + Hnum); }
		 * 
		 * sum = Hnum + Jnum; if(sum<=100) {
		 * 
		 * System.out.println("sum: " + sum);
		 * 
		 * } }
		 */
		
//		문제 5 for -> while
		System.out.println("-----문제[5]-----");
		
		/*for(int i=0; i<=10; i++) {

			for(int j=0; j<=i; j++)

			System.out.print("*");

			System.out.println();

			} */
		
		int i = 0;
		int j = 0;
		while(i<=10) {
			i++;
			System.out.println(" ");
			while(j<=i) {
				j++;
				System.out.print("*");				
			} 			
		} 
		
//		문제 6 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을작성하시오.
		System.out.println("-----문제[6]-----");
		
		sum = 0;
		for(i=1; i<=6; i++) {
			for(j=1; j<=6; j++) {
				sum = i + j;
				if(sum==6) {
					System.out.println(i + "+"  + j + "=" +  sum);
				}
			} 
		}
		
//		문제 7 
		
	}

}
