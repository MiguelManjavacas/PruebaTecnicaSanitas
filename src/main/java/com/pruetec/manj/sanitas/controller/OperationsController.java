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
	public ResponseEntity<ApiResponseDto<BigDecimal>> operations (@RequestParam(value= "operador1", required= true) BigDecimal operador1,
			@RequestParam(value= "operador", required= true) String operador,
			@RequestParam(value= "operador2", required= true) BigDecimal operador2) {
		service.operaciones();
		BigDecimal decimal = new BigDecimal(0.01);
		return new ResponseEntity<>(new ApiResponseDto<BigDecimal>(ApiResponseDto.OK, HttpStatus.OK.value(), "Resultado de la operacion.", decimal), HttpStatus.OK);
	}
	
	
}
