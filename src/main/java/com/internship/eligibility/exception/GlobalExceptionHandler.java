package com.internship.eligibility.exception;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(ApiException.class) ResponseEntity<Map<String,Object>> api(ApiException e){return ResponseEntity.status(e.getStatus()).body(Map.of("message",e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){List<String> errors=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).toList(); return ResponseEntity.badRequest().body(Map.of("message","Validation failed","errors",errors));}
 @ExceptionHandler(Exception.class) ResponseEntity<Map<String,Object>> other(Exception e){return ResponseEntity.status(500).body(Map.of("message",e.getMessage()==null?"Internal server error":e.getMessage()));}
}
