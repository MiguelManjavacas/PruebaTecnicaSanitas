package com.pruetec.manj.sanitas.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pruetec.manj.sanitas.dto.ApiResponseDto;
/**
 * 
 * @author Miguel Angel Manjavacas
 * Clase para gestionar excepciones
 *
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Metodo por defecto para gestion excepciones
	 * @param Exception ex
	 * @param WebRequest request
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> defaultErrorHandler (Exception ex, WebRequest request) {
		Object object = new ApiResponseDto<String>(ApiResponseDto.KO, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return handleExceptionInternal(ex, object, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Metodo para gestion excepciones de entrada de datos
	 * @param IllegalArgumentException ex
	 * @param WebRequest request
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> anotherDefaultErrorHandler (IllegalArgumentException ex, WebRequest request) {
		Object object = new ApiResponseDto<String>(ApiResponseDto.KO, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return handleExceptionInternal(ex, object, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
