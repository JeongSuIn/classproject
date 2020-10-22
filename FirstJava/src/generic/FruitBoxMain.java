package generic;

public class FruitBoxMain {

	public static void main(String[] args) {
		
		AppleBox appleBox = new AppleBox();
		appleBox.store(new Apple(10));	// 인스턴스를 참조하는 참조값만 가져가야 함.
		Apple apple = appleBox.pullOut();		// 
		apple.showWeight();
		
		OrangeBox orangeBox = new OrangeBox();
		//orangeBox.store(new String("오렌지")); => "오렌지"자리에 오렌지만 들어가야함.
		orangeBox.store(new Orange(100));
		Orange orange = orangeBox.pullOut();
		orange.showSugarContent();
		
		
	}

}
