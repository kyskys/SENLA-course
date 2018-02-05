package jwt;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTFilter implements Filter {

	private FilterConfig config;
	private static final int STATUS_CODE_UNAUTHORISED = 401;
	private static final String REQUEST_AUTH_HEADER = "Auth";
	private final JWTManager manager = JWTManager.getInstance();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader(REQUEST_AUTH_HEADER);
		if (manager.verifyToken(token)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setContentLength(0);
			httpResponse.setStatus(STATUS_CODE_UNAUTHORISED);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void destroy() {
		this.config = null;
	}

}
