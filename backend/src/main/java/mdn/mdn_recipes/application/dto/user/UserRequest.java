package mdn.mdn_recipes.application.dto.user;

/**
 * DTO de entrada para criação de usuário.
 * Convertido de record para classe comum para evitar problemas de compilação / desserialização.
 */
public class UserRequest {
	private String username;
	private String password;

	public UserRequest() {
	}

	public UserRequest(String username, String password) {
		this.username = username;
		this.password = password;
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
}