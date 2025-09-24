package com.firstproject.exceptions;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import com.firstproject.config.InterceptorConfig;
import com.firstproject.dto.ResponseDto;
import com.firstproject.enums.Status;

@ControllerAdvice
public class GlobaExceptionHandler {

    private final InterceptorConfig interceptorConfig;

    GlobaExceptionHandler(InterceptorConfig interceptorConfig) {
        this.interceptorConfig = interceptorConfig;
    }
    
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ResponseDto> handleResponseStatusException(ResponseStatusException e){
    	return ResponseEntity
    			.status(e.getStatusCode())
    			.body(new ResponseDto(Status.FAILURE, e.getReason()));
    	
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDto> handleException(Exception exception){
		exception.printStackTrace();
		return ResponseEntity.
				status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseDto(Status.FAILURE, exception.getMessage()));
	}

}
