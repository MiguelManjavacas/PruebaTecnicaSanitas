package com.pruetec.manj.sanitas.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pruetec.manj.sanitas.utils.Constants;

@Service
public class OperationsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationsService.class);

	public BigDecimal operations (BigDecimal operando1, String operador, BigDecimal operando2) throws Exception {
		BigDecimal result = executeOperation(operando1, operador, operando2);
		return result;
	}

	private BigDecimal executeOperation (BigDecimal operando1, String operador, BigDecimal operando2) throws Exception {
		BigDecimal resultOperation = new BigDecimal(0.0);
		if (operador.equals(Constants.ADD)) {
			resultOperation = executeAdd(operando1, operando2);

		} else if (operador.equals(Constants.SUBSTRACT)) {
			resultOperation = executeSubtract(operando1, operando2);

		} else if (operador.equals(Constants.MULTIPLY)) {
			resultOperation = executeMultiply(operando1, operando2);

		} else if (operador.equals(Constants.DIVIDE)) {
			resultOperation = executeDivide(operando1, operando2);
		} else {
			LOGGER.error("Operacion no soportada. ");
			throw new Exception("Operacion no soportada. ");
		}
		return resultOperation;
	}

	private BigDecimal executeAdd (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultAdd = operando1.add(operando2);
		LOGGER.info("Ejecutamos la suma " + operando1 + " + " + operando2 + ", con resultado " + resultAdd + ".");
		return resultAdd;
	}

	private BigDecimal executeSubtract (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultSubtract = operando1.subtract(operando2);
		LOGGER.info("Ejecutamos la resta " + operando1 + " - " + operando2 + ", con resultado " + resultSubtract + ".");
		return resultSubtract;
	}

	private BigDecimal executeMultiply (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultMultiply = operando1.multiply(operando2);
		LOGGER.info("Ejecutamos la multiplicacion " + operando1 + " * " + operando2 + ", con resultado " + resultMultiply + ".");
		return resultMultiply;
	}

	private BigDecimal executeDivide (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultDivide = operando1.divide(operando2, 0, RoundingMode.HALF_DOWN);
		LOGGER.info("Ejecutamos la division " + operando1 + " / " + operando2 + ", con resultado " + resultDivide + ".");
		return resultDivide;
	}

}
