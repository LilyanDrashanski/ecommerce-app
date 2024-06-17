package com.lily.ecommerce.handler

import com.lily.ecommerce.exception.ProductPurchaseException
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ProductPurchaseException::class)
    fun handle(exception: ProductPurchaseException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.message)
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errors = hashMapOf<String, String?>()
        exception.bindingResult.allErrors.forEach { error ->
            val fieldError = error as FieldError
            val fieldName = fieldError.field
            val errorMessage = fieldError.defaultMessage
            errors[fieldName] = errorMessage
        }
        return ResponseEntity
            .status(HttpStatus.BAD_GATEWAY)
            .body(ErrorResponse(errors))
    }
    @ExceptionHandler(EntityNotFoundException::class)
    fun handle(exception: EntityNotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.message)
    }

}