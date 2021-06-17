package com.devcom.boot.errorhandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devcom.boot.exception.FeedNotFoundException;

@ControllerAdvice
public class FeedException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(FeedNotFoundException.class)
	public ResponseEntity<?> handleFeedNotFoundError(FeedNotFoundException e){
		
		Map<String,Object> error = new HashMap<>();
		
		error.put("error","Failed Feed");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	

	
	
	
 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
		 Map<String,Object> error = new HashMap<>();
			error.put("error","Validation Failed For  Feed");
			error.put("message", e.getMessage());
			error.put("timeStamp", LocalDate.now().toString());
			return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
	    }
	
	
}
