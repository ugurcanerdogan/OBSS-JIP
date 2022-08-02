package tr.com.obss.ji.springdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User extends EntityBase {

	@Column(name = "USERNAME", length = 255, unique = true)
	private String username;

	@Column(name = "PASSWORD", length = 255)
	private String password;

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

}
