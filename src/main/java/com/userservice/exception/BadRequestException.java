package com.userservice.exception;

import org.springframework.stereotype.Component;

@Component
public class BadRequestException extends CustomException {

	private static final long serialVersionUID = 100L;
	
	public BadRequestException() {
		
	}
	
	/*public BadRequestException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}*/

}
