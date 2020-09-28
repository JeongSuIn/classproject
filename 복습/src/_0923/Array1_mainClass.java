package _0923;

public class Array1_mainClass {

	public static void main(String[] args) {
		int arraylang[] = null;
		System.out.println("arraylang: " + arraylang);
		
		arraylang = new int[5];
		System.out.println("arraylang[0]: " + arraylang[0]);
		
		arraylang[0] = 90;
		arraylang[1] = 85;
		arraylang[2] = 100;
		arraylang[3] = 95;
		arraylang[4] = 75;
		
		System.out.println("arraylang[0]: " + arraylang[0]);
		System.out.println("arraylang[1]: " + arraylang[1]);
		System.out.println("arraylang[2]: " + arraylang[2]);
		System.out.println("arraylang[3]: " + arraylang[3]);
		System.out.println("arraylang[4]: " + arraylang[4]);
		
		int arrNum[] = {90, 100, 85};
		System.out.println("arrNum[0]: " + arrNum[0] );
		
		char arrChar[] = {'A', 'B', 'C'};
		System.out.println("arrChar[1]: " + arrChar[1]);
		
//		arrChar = {'A', 'B', 'C'}; => 불가능
		arrChar = new char[3];
		arrChar[0] = 'A'; // 차례대로 선언 또는 선언과 동시에 초기화 해야됨.
		
		int array[] = {11,22,33};
		int alias[] = array;
		
		System.out.println("alias[1]: "+ alias[1]);
		alias[1] = 222;
		System.out.println("alias[1]: "+ alias[1]);
		
		System.out.println("array[1]: " +array[1]);
		
		int Atype[] = {1, 2, 3};
		int Btype[] = {11, 22, 33};
		
		int temp;
		
		int aliasA[] = Atype;
		int aliasB[] = Btype;
		int aliastemp[];
		
		aliastemp = aliasA;
		aliasA = aliasB;
		aliasB = aliastemp;
		
		System.out.println("Atype[0]: " + Atype[0]); // =>출력값: Atype[0]: 1

		System.out.println("Atype[1]: " + Atype[1]); // =>출력값: Atype[1]: 2

		System.out.println("Atype[2]: " + Atype[2]); // =>출력값: Atype[2]: 3


		System.out.println("aliasA[0]: " + aliasA[0]); // =>출력값: aliasA[0]: 11

		System.out.println("aliasA[1]: " + aliasA[1]); // =>출력값: aliasA[1]: 22

		System.out.println("aliasA[2]: " + aliasA[2]); // =>출력값: aliasA[2]: 33

	}	
}