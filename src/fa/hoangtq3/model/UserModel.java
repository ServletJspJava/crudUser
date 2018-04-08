
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.model;

public class UserModel {
	private int idus;
	private String fullname;
	private String gender;
	private String email;
	private String username;
	private String password;
	private String role;

	
	
	public int getIdus() {
		return idus;
	}



	public void setIdus(int idus) {
		this.idus = idus;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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



	@Override
	public String toString() {
		return "User [idus=" + idus + ", fullname=" + fullname
				+ ", gender=" + gender + ", email=" + email + ", username="
				+ username + ", password="+ password +", role="+ "role ]";
	}

}
