package tennis_club;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("klient").password(passwordEncoder().encode("klient123")).roles("KLIENT")
				.and().withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/anonymous*")
				.anonymous().antMatchers("/login*").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/", true)
				.failureUrl("/login?error=true").failureHandler(getAuthenticationFailureHandler()).and().logout()
				.logoutUrl("/wylogowanie").deleteCookies("JSESSIONID");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return new MyAuthenticationFailureHandler();
	}

	public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

		@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.sendRedirect("/login?loginError=true");
		}
	}
}