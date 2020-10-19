package ver04;

public class PhoneCompanyInfor extends PhoneInfor4 {

	// 변수 생성
	private String company;
	
	public PhoneCompanyInfor(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;		
	}
	
	@Override
	void showInfor() {		
		super.showInfor();
		System.out.println("회사 >> " + company);		
	}

	

}
