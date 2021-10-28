package java5.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@NotBlank(message = "Không để trống mã người dùng!")
	private String username;
	@NotBlank(message = "Không để trống mật khẩu!")
	private String password;
	@NotBlank(message = "Không để trống họ tên!")
	private String fullname;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
}
