package com.userservice.exception;

import org.springframework.stereotype.Component;

@Component
public class DuplicateEmailException extends CustomException {

	private static final long serialVersionUID = 100L;
	
	public DuplicateEmailException() {
		
	}
}
