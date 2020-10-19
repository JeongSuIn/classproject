package ver04;

public class PhoneUnivInfor4 extends PhoneInfor4 {

	private String major;
	private String year;
	
	public PhoneUnivInfor4(String name, String phoneNumber, String address, String email, String major, String year ) {
		super(name, phoneNumber, address, email);	
		this.major = major;
		this.year = year;
		
	}

	@Override
	void showInfor() {		
		super.showInfor();
		System.out.println("전공 >> " + major);
		System.out.println("학년 >> " + year);
	}
	
}
