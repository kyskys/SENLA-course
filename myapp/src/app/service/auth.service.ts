export class AuthService{

	setToken(token: string) {
		localStorage.setItem('token',token);
	}

	getToken(): string {
		return localStorage.getItem('token');
	}
	
}