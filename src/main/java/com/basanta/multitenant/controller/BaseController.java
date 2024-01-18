package com.basanta.multitenant.controller;

import com.basanta.multitenant.exception.InvalidRequestBodyException;
import com.basanta.multitenant.message.CustomMessageSource;
import com.basanta.multitenant.response.GlobalApiResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class BaseController {

    /**
     * API Success Status
     */
    protected final boolean API_SUCCESS_STATUS = true;
    /**
     * API Error Status
     */
    protected final boolean API_ERROR_STATUS = false;

    @Autowired
    protected CustomMessageSource customMessageSource;

    protected GlobalApiResponse successResponse(String message, Object data) {
        return GlobalApiResponse.builder()
                .status(API_SUCCESS_STATUS)
                .message(message)
                .data(data)
                .build();
    }

    protected GlobalApiResponse errorResponse(String message, Object errors) {
        return GlobalApiResponse.builder()
                .status(API_ERROR_STATUS)
                .message(message)
                .data(errors)
                .build();
    }

    protected void validateRequestBody(BindingResult bindingResults) throws InvalidRequestBodyException {
        if (bindingResults.hasErrors()) {
            List<FieldError> errors = bindingResults.getFieldErrors();
            StringBuilder error_definition = new StringBuilder();
            for (FieldError error : errors) {
                error_definition.append(error.getField() + " " + error.getDefaultMessage()).append(",");
            }
            throw new InvalidRequestBodyException(error_definition.toString());
        }
    }
}
