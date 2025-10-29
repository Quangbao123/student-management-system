package com.student_management.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.student_management.dto.response.ApiResponse;
import com.student_management.enums.ErrorCode;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	ResponseEntity<ApiResponse> handlingException(Exception exception){
		ApiResponse apiResponse = new ApiResponse();
		
		apiResponse.setSuccess(false);
		apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
		apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
		
		return ResponseEntity.badRequest().body(apiResponse);
	}
	
	@ExceptionHandler(value = CustomException.class)
	ResponseEntity<ApiResponse> handlingCustomException(CustomException exception){
		ErrorCode errorCode = exception.getErrorCode();
		ApiResponse apiResponse = new ApiResponse();
		
		apiResponse.setSuccess(false);
		apiResponse.setCode(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());
		
		return ResponseEntity.badRequest().body(apiResponse);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
		String enumKey = exception.getFieldError().getDefaultMessage();
		ErrorCode errorCode = ErrorCode.valueOf(enumKey);
		
		ApiResponse apiResponse = new ApiResponse();
		
		apiResponse.setSuccess(false);
		apiResponse.setCode(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());
		
		return ResponseEntity.badRequest().body(apiResponse);
	}
	
}
