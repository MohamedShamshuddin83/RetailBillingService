package com.apps.store.billing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class BillingServiceException extends RuntimeException{

	public BillingServiceException(String message) {
		super(message);
	}

	public BillingServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
