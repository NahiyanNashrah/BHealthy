package com.doctormanagement.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
 
public class LoginForm {
    @NotBlank
    @Size(min=3, max = 60)
    private String phonenumber;
 
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
 
 
 
    public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}