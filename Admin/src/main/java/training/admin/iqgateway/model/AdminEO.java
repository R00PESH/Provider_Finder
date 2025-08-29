package training.admin.iqgateway.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
public class AdminEO {
	
	@Id
	private String _id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String role;

	public AdminEO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEO(String _id, String name, String email, String password, String role) {
		super();
		this._id = _id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
