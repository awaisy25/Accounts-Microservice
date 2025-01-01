package com.project.Accounts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issueUri;
	
	  @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests(authorize -> 
			authorize
			//hello world and account registration can access
			.requestMatchers(new AntPathRequestMatcher("/hello"), new AntPathRequestMatcher("/register")).permitAll()).csrf(AbstractHttpConfigurer::disable);
			
			http.authorizeHttpRequests(authorize -> 
			authorize
			.anyRequest().authenticated())
			.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())));
			return http.build();
			
		}
	    
	    @Bean
	    JwtDecoder jwtDecoder() {
	    	return JwtDecoders.fromIssuerLocation(issueUri);
	    }
}
