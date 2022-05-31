package com.my.users.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private final ErrorAttributes errorAttributes;

    @ExceptionHandler(UserAppException.class)
    public ResponseEntity<Map<String, Object>> appException(UserAppException ex, WebRequest request) {
        Map<String, Object> body = errorAttributes.getErrorAttributes(request, ex.getOptions());
        log.error("UserApp Exception", ex);
        HttpStatus status = ex.getStatus();
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public VndErrors.VndError handleMethodArgumentNotValid(ResourceNotFoundException ex) {
        String correlationId = generateId();
        log.error("logref: {}", correlationId, ex);

        return new VndErrors.VndError(correlationId, ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("Exception", ex);
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

