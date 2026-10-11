package com.internship.eligibility.dto;
import jakarta.validation.constraints.*; import java.util.List;
public final class StudentDto {
 public record UpdateRequest(@NotBlank String name,@NotBlank String phone,@NotBlank String branch,@NotNull Integer year,@NotNull @DecimalMin("0") @DecimalMax("10") Double cgpa,List<String> skills,List<String> certifications,String resumeLink){}
 private StudentDto(){}
}
