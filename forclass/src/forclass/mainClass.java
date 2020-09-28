package forclass;

public class mainClass {

	public static void main(String[] args) {
		/*
			순환문 : loop문
			조건이 만족하면 반복 실행되는 제어문
			
			for문, foreach
			
			형식:			
			for( 변수선언 또는 초기화(1) ; 조건문(2)(5)(8)(11) ; 연산식(4)(7)(10) ){
				// 처리(3)(6)(9)
			}			
			(12)
			
			for( 변수선언 : 배열 or 목록){
				처리
			}
		*/
		
		int n;		
		for(n = 0;n < 5; n++) {
			System.out.println("for loop");
		}		
		System.out.println("n = " + n);
		
		for(int i = 0;i < 10; i++) {
		//	System.out.println("i = " + i);
		}
		
		for(int i = 0;i < 10; i = i + 2) {
		//	System.out.println("i = " + i);
		}
		
		for(int i = 1; i <= 100; i++) {
			System.out.println("i = " + i);
		}
		
		int sum = 0;		
		for(int i = 1; i <= 10; i++) {
			sum = sum + i;
		}		
		System.out.println("sum:" + sum);
		
		for(int i = 10;i > 0; i--) {
			System.out.println("i = " + i);
		}
		
		int array[] = { 12, 34, -23, 45, -37, 67, 89 };
		
		// 배열의 길이
		System.out.println("array.length:" + array.length);
		
		sum = 0;
	//	sum = array[0] + array[1] + array[2] + array[3] + array[4];
		
		for(int i = 0;i < array.length; i++) {
		//	if(array[i] > 0) {
				sum = sum + array[i];
		//	}
		}
		System.out.println("sum:" + sum);
		
		// foreach
		for(int num : array) {	// num = [0],  num = [1] 
			System.out.println("num = " + num);
		}
				
		// 1 ~ 100 사이에 있는 숫자 중 짝수들의 합, 홀수들의 합을 구하라.
		int sum1, sum2;
		sum1 = sum2 = 0;
		
		for(int i = 1;i <= 100; i++) {
			if(i % 2 == 1) {
				sum1 = sum1 + i;
			}
			else {
				sum2 = sum2 + i;
			}
		}
		System.out.println("sum1 = " + sum1);
		System.out.println("sum2 = " + sum2);
		
		
		
		// char arrch[] = { 'D', 'W', 'O', 'A', 'B' };
		// character array에서 'A' 를 찾아서 'a'로 변경하고 출력하라.
		/*
		for(int i = 0;i < arrch.length; i++) {
		//	System.out.println("arrch = " + arrch[i]);
			if(arrch[i] == 'A') {
				arrch[i] = 'a';
			}
		}
		*/
		/*
		int index = 0;
		for(char c : arrch) {
			if(c == 'A') {
				arrch[index] = 'a';
			}
			index++;
		}
		
		for(int i = 0;i < arrch.length; i++) {
			System.out.print(arrch[i]);
		}
		*/
		
		char arrch[] = { 'D', 'W', 'O', 'A', 'B' };
		// 모두 소문자로 변경한 후 출력하라.	 ASCII
		// A = 65  a = 97 -> 32
		// System.out.println("asc = " + (int)arrch[0]);
		int asc = (int)arrch[0];	// ascii code
		asc = asc + 32;				// 소문자로 변환
		char ch = (char)asc;		// 문자로 변환
		System.out.println("ch = " + ch);
		
		for(int i = 0;i < arrch.length; i++) {
			char c = arrch[i];
			int as = (int)c;
			as = as + 32;
			arrch[i] = (char)as;
		}
		
		for(int i = 0;i < arrch.length; i++) {
			System.out.print(arrch[i]);
		}
		
	}

}





