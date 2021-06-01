package com.learn.ExceptionHandle;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerClass {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){
		return new ResponseEntity<>(exception.getBindingResult().getFieldError().getDefaultMessage(),
				HttpStatus.BAD_REQUEST);
	}
}


//
//package com.example.springboot.validation;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ExceptionHandlerClass {
//@ExceptionHandler(MethodArgumentNotValidException.class)
//public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
//return new ResponseEntity<>(exception.getBindingResult().getFieldError().getDefaultMessage(),
//HttpStatus.BAD_REQUEST);
//}
//}