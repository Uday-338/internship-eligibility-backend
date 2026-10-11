package com.internship.eligibility.dto;
import jakarta.validation.constraints.NotNull; import com.internship.eligibility.entity.ApplicationStatus;
public final class ApplicationDto { public record CreateRequest(@NotNull Long internshipId){} public record StatusRequest(@NotNull ApplicationStatus status){} private ApplicationDto(){} }
