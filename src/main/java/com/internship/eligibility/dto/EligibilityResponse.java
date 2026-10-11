package com.internship.eligibility.dto;
import java.util.List;
public record EligibilityResponse(boolean eligible,double skillMatchPercentage,List<String> reasons,List<String> missingSkills,List<String> suggestions){}
