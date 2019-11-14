package com.doctormanagement.message.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    Collection<? extends GrantedAuthority> authorities;
    String name,phonenumber;
         
 
    public JwtResponse(String accessToken,Collection<? extends GrantedAuthority> authorities,String name,String phonenumber) {
        this.token = accessToken;
        this.authorities = authorities;
        this.name = name;
        this.phonenumber = phonenumber;
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
    
    
}
