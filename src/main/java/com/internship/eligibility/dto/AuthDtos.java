package com.internship.eligibility.dto;
import jakarta.validation.constraints.*;
public final class AuthDtos {
 public record RegisterRequest(@NotBlank String name,@Email @NotBlank String email,@NotBlank String phone,@NotBlank String branch,@NotNull Integer year,@NotNull @DecimalMin("0") @DecimalMax("10") Double cgpa,@Size(min=6) String password){}
 public record LoginRequest(@Email @NotBlank String email,@NotBlank String password,@NotNull String role){}
 public record UserResponse(Long id,String name,String email,String role){}
 public record LoginResponse(String token,UserResponse user){}
 private AuthDtos(){}
}
