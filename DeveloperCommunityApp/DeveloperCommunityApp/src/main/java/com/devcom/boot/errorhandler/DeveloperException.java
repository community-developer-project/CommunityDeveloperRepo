package com.devcom.boot.errorhandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devcom.boot.exception.DeveloperAlreadyExistsException;
import com.devcom.boot.exception.UnknownDeveloperException;


@ControllerAdvice
public class DeveloperException {

	@ExceptionHandler(DeveloperAlreadyExistsException.class)
	public ResponseEntity<?> handleDeveloperDataError(DeveloperAlreadyExistsException e) {

		Map<String, Object> error = new LinkedHashMap<>();

		error.put("error", "Developer Already Exists");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UnknownDeveloperException.class)
	public ResponseEntity<?> handleDeveloperDataError(UnknownDeveloperException e) {

		Map<String, Object> error = new LinkedHashMap<>();

		error.put("error", "Developer Not Found");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

}
