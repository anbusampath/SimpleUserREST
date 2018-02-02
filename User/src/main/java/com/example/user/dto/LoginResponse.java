package com.example.user.dto;

public class LoginResponse {

	Boolean loginStaus;
	String errorMessage;

	public LoginResponse() {
		
	}

	public Boolean getLoginStaus() {
		return loginStaus;
	}

	public void setLoginStaus(Boolean loginStaus) {
		this.loginStaus = loginStaus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LoginResponse [loginStaus=" + loginStaus + ", errorMessage=" + errorMessage + "]";
	}

	public LoginResponse(Boolean loginStaus, String errorMessage) {
		super();
		this.loginStaus = loginStaus;
		this.errorMessage = errorMessage;
	}

}