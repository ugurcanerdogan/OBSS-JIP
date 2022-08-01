package tr.com.obss.ji.springdemo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Component
public class RequestInFilter extends CommonsRequestLoggingFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestInFilter.class);

	@Override
	protected boolean shouldLog(HttpServletRequest request) {
		var pathInfo = request.getRequestURI();
		return pathInfo.contains("/api/");
	}

	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		LOGGER.info("Request filter started. {} {}", request.getRequestURI(), request.getMethod());
		super.beforeRequest(request, message);
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		LOGGER.info("Request filter finished. {} {}", request.getRequestURI(), request.getMethod());
		super.afterRequest(request, message);
	}

}
