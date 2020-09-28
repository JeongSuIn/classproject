package _0923;

public class forClass_mainClass {

	public static void main(String[] args) {
	
		int sum1, sum2;
		sum1 = 0;
		sum2 = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%2 ==1) {
				sum1 += i;
				
			} else {
				sum2 += i;
			}
		}
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
		
	}
}
