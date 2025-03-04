package com.cybaemtech.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ValidationProcessor
{
	static final Logger logger = LogManager.getLogger(ValidationProcessor.class);

	public static void processValidationErrors(final BindingResult result)
	{
		final List<FieldError> fieldErrors = result.getFieldErrors();
		final List<String> errorMessages = new ArrayList<>();

		for (FieldError error : fieldErrors)
		{
			String message = "Field '" + error.getField() + "' " + error.getDefaultMessage();

			logger.info("Validation failure : {}", message);

			errorMessages.add(message);
		}

		throw new RuntimeException(errorMessages.toString());
	}
}
