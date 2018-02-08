package jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.RequestContextFilter;

import com.senla.entities.User;

import holder.CurrentUserHolder;
import provider.ApplicationContextProvider;

public class JWTFilter extends RequestContextFilter {

	private static final int STATUS_CODE_UNAUTHORISED = 401;
	private static final String REQUEST_AUTH_HEADER = "Auth";

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String token = request.getHeader(REQUEST_AUTH_HEADER);
		if (JWTManager.verifyToken(token)) {
			User user = JWTManager.getCurrentUserByToken(token);
			setCurrentUser(user);
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setContentLength(0);
			httpResponse.setStatus(STATUS_CODE_UNAUTHORISED);
		}
	}
	
	private void setCurrentUser(User user) {
		CurrentUserHolder userHolder = ApplicationContextProvider.getApplicationContext().getBean(CurrentUserHolder.class);
		userHolder.setUser(user);
	}
}
