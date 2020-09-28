package _0924;

public class WhileClass {

	public static void main(String[] args) {
		
		int w;
		w = 0;
		while(w<100) {
			System.out.println("w = " + w);
			if(w == 56) {
				
				break;
			}
			w++;
		}
		
		
		w = 0;
		while(w<10) {
			System.out.println("while start");
			System.out.println("w = " + w);
			w++;
			if(w>4) {
				continue;
				
			}
			System.out.println("while end");
		}

	}

}
