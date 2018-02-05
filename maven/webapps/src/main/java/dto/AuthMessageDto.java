package dto;

import com.senla.util.AuthCodeEnum;

public class AuthMessageDto {

	private int code;
	private String token;

	public AuthMessageDto() {
	}

	public AuthMessageDto(AuthCodeEnum code, String token) {
		this.code = code.getCode();
		this.token = token;
	}

	public AuthMessageDto(AuthCodeEnum code) {
		this(code, null);
	}

	public int getCode() {
		return code;
	}

	public String getToken() {
		return token;
	}
}
