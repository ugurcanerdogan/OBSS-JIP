package tr.com.obss.ji.springdemo.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import tr.com.obss.ji.springdemo.filter.RequestInFilter;

@Component
public class RequestInInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestInFilter.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		request.setAttribute("startDate", new Date());
		LOGGER.info("Request interceptor started. {} {}", request.getRequestURI(), request.getMethod());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		var startDate = (Date) request.getAttribute("startDate");
		var endDate = new Date();
		var elapsed = endDate.getTime() - startDate.getTime();
		LOGGER.info("Request interceptor finished. {} {} ELAPSED : {}", request.getRequestURI(), request.getMethod(),
				elapsed);
	}

}
