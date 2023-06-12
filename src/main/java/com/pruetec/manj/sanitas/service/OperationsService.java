package com.pruetec.manj.sanitas.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pruetec.manj.sanitas.utils.Constants;

/**
 * 
 * @author Miguel Angel Manjavacas
 * Clase que actua como servicio para ejecutar la funcionalidad de la aplicacion.
 *
 */

@Service
public class OperationsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationsService.class);

	/**
	 * Metodo principal de la funcionalidad.
	 * @param BigDecimal operando1
	 * @param String operador
	 * @param BigDecimal operando2
	 * @return Big Decimal result
	 * @throws Exception
	 */
	public BigDecimal operations (BigDecimal operando1, String operador, BigDecimal operando2) throws Exception {
		BigDecimal result = executeOperation(operando1, operador, operando2);
		return result;
	}

	/**
	 * Metodo que gestiona la funcionalidad operativa.
	 * @param BigDecimal operando1
	 * @param String operador
	 * @param BigDecimal operando2
	 * @return BigDecimal resultOperation
	 * @throws Exception
	 */
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

	/**
	 * Metodo que gestiona la operacion de suma.
	 * @param BigDecimal operando1
	 * @param BigDecimal operando2
	 * @return BigDecimal resultAdd
	 */
	private BigDecimal executeAdd (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultAdd = operando1.add(operando2);
		LOGGER.info("Ejecutamos la suma " + operando1 + " + " + operando2 + ", con resultado " + resultAdd + ".");
		return resultAdd;
	}

	/**
	 * Metodo que gestiona la operacion de resta.
	 * @param BigDecimal operando1
	 * @param BigDecimal operando2
	 * @return BigDecimal resultSubtract
	 */
	private BigDecimal executeSubtract (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultSubtract = operando1.subtract(operando2);
		LOGGER.info("Ejecutamos la resta " + operando1 + " - " + operando2 + ", con resultado " + resultSubtract + ".");
		return resultSubtract;
	}

	/**
	 * Metodo que gestiona la operacion de multiplicacion.
	 * @param BigDecimal operando1
	 * @param BigDecimal operando2
	 * @return BigDecimal resultMultiply
	 */
	private BigDecimal executeMultiply (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultMultiply = operando1.multiply(operando2);
		LOGGER.info("Ejecutamos la multiplicacion " + operando1 + " * " + operando2 + ", con resultado " + resultMultiply + ".");
		return resultMultiply;
	}

	/**
	 * Metodo que gestiona la operacion de division.
	 * @param BigDecimal operando1
	 * @param BigDecimal operando2
	 * @return BigDecimal resultDivide
	 */
	private BigDecimal executeDivide (BigDecimal operando1, BigDecimal operando2) {
		BigDecimal resultDivide = operando1.divide(operando2, 0, RoundingMode.HALF_DOWN);
		LOGGER.info("Ejecutamos la division " + operando1 + " / " + operando2 + ", con resultado " + resultDivide + ".");
		return resultDivide;
	}

}
