package dto;

import com.senla.entities.User;

public class UserDetailsDto {
	private String email;
	private String name;

	public UserDetailsDto(User user) {
		this.email = user.getEmail();
		this.name = user.getName();
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
}
