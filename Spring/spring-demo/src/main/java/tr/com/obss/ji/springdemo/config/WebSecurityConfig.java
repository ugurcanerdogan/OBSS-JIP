package tr.com.obss.ji.springdemo.config;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import tr.com.obss.ji.springdemo.service.UserService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = { //
			"/api/v1/h2-console", //
			"/api/v1/h2-console/**", //
			"/api/v1/v2/api-docs", //
			"/api/v1/swagger-resources", //
			"/api/v1/swagger-resources/**", //
			"/api/v1/configuration/ui", //
			"/api/v1/configuration/security", //
			"/api/v1/swagger-ui.html", //
			"/api/v1/webjars/**", //
			"/api/v1/graphiql", //
			"/api/v1/api/graphql", //
	};

	private final PasswordEncoder encoder;

	private final UserService userService;

	public WebSecurityConfig(PasswordEncoder encoder, UserService userService) {
		this.encoder = encoder;
		this.userService = userService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(AUTH_WHITELIST).anonymous().anyRequest().hasAnyRole("ADMIN", "USER").and()
				.exceptionHandling().accessDeniedHandler((req, resp, ex) -> resp.setStatus(SC_FORBIDDEN)) // if
																											// someone
																											// tries
																											// to
																											// access
																											// protected
																											// resource
																											// but
																											// doesn't
																											// have
																											// enough
																											// permissions
				.authenticationEntryPoint((req, resp, ex) -> resp.setStatus(SC_UNAUTHORIZED)).and().formLogin()
				.loginProcessingUrl("/login").successHandler((req, resp, auth) -> resp.setStatus(SC_OK)) // success
																											// authentication
				.failureHandler((req, resp, ex) -> resp.setStatus(SC_FORBIDDEN)).and() // bad
																						// credentials
				.sessionManagement().invalidSessionStrategy((req, resp) -> resp.setStatus(SC_UNAUTHORIZED)).and()
				.logout().logoutUrl("/logout").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).and()
				.csrf().disable();

		// http.csrf().disable().authorizeRequests().anyRequest().permitAll(); //
		// Works for GET, POST, PUT, DELETE
	}

}
