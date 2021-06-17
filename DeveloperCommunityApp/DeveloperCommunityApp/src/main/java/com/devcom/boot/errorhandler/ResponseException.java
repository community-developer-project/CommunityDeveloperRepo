package com.devcom.boot.errorhandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devcom.boot.exception.NoResponsesFoundException;
import com.devcom.boot.exception.ResponseAlreadyExistsException;
import com.devcom.boot.exception.UnknownResponseException;



@ControllerAdvice
public class ResponseException {

	@ExceptionHandler(ResponseAlreadyExistsException.class)
	public ResponseEntity<?> handleEmployeeDataError(ResponseAlreadyExistsException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error","Failed Response");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	@ExceptionHandler(UnknownResponseException.class)
	public ResponseEntity<?> handleEmployeeDataError(UnknownResponseException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error","Failed Response");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	@ExceptionHandler(NoResponsesFoundException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoResponsesFoundException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error","Failed Response");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}

}
