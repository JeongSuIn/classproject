package ver05;

public class PhoneCompanyInfor5 extends PhoneInfor5 {

	// 회사명 변수 생성
	private String company;

	public PhoneCompanyInfor5(String name, String phoneNumber, String address, String email, String company) {
		super(name, phoneNumber, address, email);
		this.company = company;
	}

	//getter/setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void showInfor() {
		super.showInfor();
		System.out.println("회사 >> " + company);
	}

	@Override
	public void showBasicInfor() {
		super.showInfor();
		
	}

	

}
