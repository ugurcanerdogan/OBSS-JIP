package tr.com.obss.ji.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tr.com.obss.ji.springdemo.interceptor.RequestInInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Autowired
	private RequestInInterceptor requestInInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInInterceptor);
	}

}
