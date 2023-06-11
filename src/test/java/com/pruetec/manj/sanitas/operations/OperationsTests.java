package com.pruetec.manj.sanitas.operations;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pruetec.manj.sanitas.controller.OperationsController;
import com.pruetec.manj.sanitas.dto.ApiResponseDto;

@SpringBootTest
class OperationsTests {

	@Autowired
	OperationsController controller;

	@Test
	void testingSumaOk() {
		ResponseEntity<ApiResponseDto<?>> apiResponse = controller.operations(new BigDecimal(1.0), "+", new BigDecimal(2.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal(3.0));
	}

	@Test
	void testingRestaOk() {
		ResponseEntity<ApiResponseDto<?>> apiResponse = controller.operations(new BigDecimal(3.0), "-", new BigDecimal(1.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal(2.0));
	}

	@Test
	void testingMultiplicacionOk() {
		ResponseEntity<ApiResponseDto<?>> apiResponse = controller.operations(new BigDecimal(2.0), "*", new BigDecimal(3.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal(6.0));
	}

	@Test
	void testingDivisionOk() {
		ResponseEntity<ApiResponseDto<?>> apiResponse = controller.operations(new BigDecimal(6.0), "/", new BigDecimal(3.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal(2.00));
	}

	@Test
	void testingOperacionNoSoportadaOk() {
		ResponseEntity<ApiResponseDto<?>> apiResponse = controller.operations(new BigDecimal(5.0), "A", new BigDecimal(5.0));
		assertThat(apiResponse.getBody().getCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

}
