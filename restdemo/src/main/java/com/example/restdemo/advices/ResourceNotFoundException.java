package com.example.restdemo.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 711762792088180408L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
