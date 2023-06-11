package com.pruetec.manj.sanitas.operations;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pruetec.manj.sanitas.controller.OperationsController;
import com.pruetec.manj.sanitas.dto.ApiResponseDto;

@SpringBootTest
class OperationsTests {

	@Autowired
	OperationsController controller;

	@Test
	void testingSumaOk() {
		ResponseEntity<ApiResponseDto<BigDecimal>> apiResponse = controller.operations(new BigDecimal(1.0), "+", new BigDecimal(2.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal("3.0"));
	}

	@Test
	void testingRestaOk() {
		ResponseEntity<ApiResponseDto<BigDecimal>> apiResponse = controller.operations(new BigDecimal(3.0), "-", new BigDecimal(1.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal("2.0"));
	}

	@Test
	void testingMultiplicacionOk() {
		ResponseEntity<ApiResponseDto<BigDecimal>> apiResponse = controller.operations(new BigDecimal(2.0), "x", new BigDecimal(3.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal("6.0"));
	}

	@Test
	void testingDivisionOk() {
		ResponseEntity<ApiResponseDto<BigDecimal>> apiResponse = controller.operations(new BigDecimal(6.0), "/", new BigDecimal(3.0));
		assertThat(apiResponse.getBody().getResult()).isEqualTo(new BigDecimal("2.0"));
	}

}
