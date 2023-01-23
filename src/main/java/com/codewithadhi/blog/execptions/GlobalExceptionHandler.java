package com.codewithadhi.blog.execptions;

import com.codewithadhi.blog.payload.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        final String message = ex.getMessage();
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(message).success(false).build(), NOT_FOUND);
    }

    @ExceptionHandler(BlogAppServiceException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(BlogAppServiceException ex){
        final String message = ex.getMessage();
        return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(message).success(false).build(), NOT_FOUND);
    }

}
