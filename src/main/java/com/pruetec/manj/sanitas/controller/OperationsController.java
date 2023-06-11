package com.pruetec.manj.sanitas.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruetec.manj.sanitas.dto.ApiResponseDto;
import com.pruetec.manj.sanitas.service.OperationsService;

@RestController
@RequestMapping("operations")
public class OperationsController {

	@Autowired
	OperationsService service;

	@GetMapping("/")
	public ResponseEntity<ApiResponseDto<?>> operations (@RequestParam(value= "operando1", required= true) BigDecimal operando1,
			@RequestParam(value= "operador", required= true) String operador,
			@RequestParam(value= "operando2", required= true) BigDecimal operando2) {
		try {
			BigDecimal resultado = service.operations(operando1, operador, operando2);
			return new ResponseEntity<>(new ApiResponseDto<BigDecimal>(ApiResponseDto.OK, HttpStatus.OK.value(), "Resultado de la operacion.", resultado), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiResponseDto<String>(ApiResponseDto.KO, HttpStatus.BAD_REQUEST.value(), "Error en operacion. ", e.getMessage()), HttpStatus.OK);
		}
		
	}
	
}
