package tr.com.obss.ji.springdemo.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdateDTO {

	@NotBlank
	@Size(max = 255, min = 3, message = "Please enter a valid password")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
