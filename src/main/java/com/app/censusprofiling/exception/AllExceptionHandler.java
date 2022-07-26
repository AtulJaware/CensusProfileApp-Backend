package com.app.censusprofiling.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.censusprofiling.entity.ErrorResponse;

@ControllerAdvice
public class AllExceptionHandler {
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(MemberNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(MemberAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(MemberAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //401 unauthorized
	}
	
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(LoginNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(LoginAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(LoginAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //401 unauthorized
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AddressNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(AddressAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(AddressAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //401 unauthorized
	}
	
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(ApplicationNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(ApplicationAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(ApplicationAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //401 unauthorized
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AdminNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  // 404 not found
	}
	
	@ExceptionHandler(AdminAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(AdminAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //401 unauthorized
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmailNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(UserAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //404 Not found
	}
	
	@ExceptionHandler(LoginInvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleException(LoginInvalidCredentialsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400 Bad Request
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);  // 400 Bad Request
	}
}