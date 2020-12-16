package form;

public class FormLogin {
	
	private String id;
	private String pw;
	
	
	public FormLogin() {
		
	}


	public FormLogin(String id, String pw) {		
		this.id = id;
		this.pw = pw;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	@Override
	public String toString() {
		return "FormLogin [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
	
	

}
