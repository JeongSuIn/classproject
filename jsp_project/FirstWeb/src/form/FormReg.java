package form;

public class FormReg {
	
	private String id;
	private String pw;
	private String name;
	private String photo;
	
	
	public FormReg() {
		
	}


	public FormReg(String id, String pw, String name, String photo) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "FromReg [id=" + id + ", pw=" + pw + ", name=" + name + ", photo=" + photo + "]";
	}
	
	
	
	
	

}
