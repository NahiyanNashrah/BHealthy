package com.doctormanagement.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    Collection<? extends GrantedAuthority> authorities;
 
    public JwtResponse(String accessToken,Collection<? extends GrantedAuthority> authorities) {
        this.token = accessToken;
        this.authorities = authorities;
    }
    
    
 
    public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}



	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}



	public String getAccessToken() {
        return token;
    }
 
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }
 
    public String getTokenType() {
        return type;
    }
 
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}
