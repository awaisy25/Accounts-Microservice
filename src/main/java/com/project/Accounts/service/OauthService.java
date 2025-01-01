package com.project.Accounts.service;

import com.mashape.unirest.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.Unirest;

@Service
public class OauthService {
	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issueUri;
	
	public String generateToken()  {
		
		try {
			HttpResponse<String> response = Unirest.post(String.format("%s/oauth/token", issueUri)).header("content-type", "application/json")
					.body("{\"client_id\":\"PMIiRCgqlNKwSLRmuDdO5or1Bb5gIxmf\",\"client_secret\":\"JgwE87CMEFywGl6Q412j6-sHSeyPbwpy5BvPuPisdHZlRV7vJGjFekwIV7jK3WNz\",\"audience\":\"https://comedysite.com/api/accounts\",\"grant_type\":\"client_credentials\"}")
					.asString();
			return response.getBody();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
}
