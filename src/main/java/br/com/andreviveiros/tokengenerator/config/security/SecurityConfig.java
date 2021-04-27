package br.com.andreviveiros.tokengenerator.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	private static final String[] ALLOW_URL = {
			"/h2-console/**"
	};
	
	private static final String[] ALLOW_URL_GET = {
			"/token-generator/**"
	};
	
	private static final String[] ALLOW_URL_POST = {
			"/token-generator/**"
	};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.cors()
			.and()
			.csrf()
			.disable();
		
		http.authorizeRequests()
			.antMatchers(ALLOW_URL).permitAll()
			.antMatchers(HttpMethod.GET,ALLOW_URL_GET).permitAll()
			.antMatchers(HttpMethod.POST,ALLOW_URL_POST).permitAll()
			.anyRequest()
			.authenticated();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		
	}
	
	@Bean
	public CorsConfigurationSource CorsBasicConfiguration() {
		
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
		
	}
	
	@Bean
	public BCryptPasswordEncoder CryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
