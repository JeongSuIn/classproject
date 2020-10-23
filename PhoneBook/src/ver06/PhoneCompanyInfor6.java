package ver06;

public class PhoneCompanyInfor6 extends PhoneInfor6 {

	// 회사명 변수 생성
	private String company;

	public PhoneCompanyInfor6(String name, String phoneNumber, String address, String email, String company) {
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

	// 20.10.21 추가
	@Override
	public void showBasicInfor() {
		super.showInfor();
		
	}

	

}
