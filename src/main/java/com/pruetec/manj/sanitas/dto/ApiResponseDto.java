package com.pruetec.manj.sanitas.dto;

public class ApiResponseDto<T> {

	public static final String OK = "ok";
	public static final String KO = "ko";
	private String status;
	private Integer code;
	private String message;
	private T result;

	public ApiResponseDto(String status, Integer code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public ApiResponseDto(String status, Integer code, String message, T result) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	

}
