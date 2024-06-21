package com.lily.ecommerce.handler

import com.lily.ecommerce.exception.CustomerNotFoundException
import com.lily.ecommerce.exception.WrongAddressFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.View

@RestControllerAdvice
class GlobalExceptionHandler(private val error: View) {

    @ExceptionHandler(CustomerNotFoundException::class)
    fun handle(exception: CustomerNotFoundException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.message)
    }

    @ExceptionHandler(WrongAddressFormat::class)
    fun handle(exception: WrongAddressFormat): ResponseEntity<String> {
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

}