package org.zerock.aws.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<Map<String,Object>> handleIllegalStateException(IllegalStateException ex) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return getErrorResponse(status, ex.getMessage());
	}

	public ResponseEntity<Map<String, Object>> getErrorResponse(HttpStatus status, String message) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("status", status.name());
		errorResponse.put("code", status.value());
		errorResponse.put("message", message);

		return new ResponseEntity<>(errorResponse, status);
	}
}
