
package com.internship.eligibility.controller;

import com.internship.eligibility.dto.ApplicationDto.StatusRequest;
import com.internship.eligibility.exception.ApiException;
import com.internship.eligibility.entity.*;
import com.internship.eligibility.repository.*;
import com.internship.eligibility.service.ApplicationService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

 private final InternshipRepository internships;
 private final StudentRepository students;
 private final ApplicationService apps;
 private final ApplicationRepository applicationRepository;

 public AdminController(
         InternshipRepository i,
         StudentRepository s,
         ApplicationService a,
         ApplicationRepository ar) {
  internships = i;
  students = s;
  apps = a;
  applicationRepository = ar;
 }

 @PostMapping("/internships")
 ResponseEntity<Internship> add(@RequestBody Internship i) {
  return ResponseEntity.status(HttpStatus.CREATED)
          .body(internships.save(i));
 }

 @PutMapping("/internships/{id}")
 Internship edit(
         @PathVariable Long id,
         @RequestBody Internship body) {

  Internship i = internships.findById(id)
          .orElseThrow(() -> new ApiException(
                  "Internship not found",
                  HttpStatus.NOT_FOUND));

  i.setCompany(body.getCompany());
  i.setTitle(body.getTitle());
  i.setLocation(body.getLocation());
  i.setDuration(body.getDuration());
  i.setStipend(body.getStipend());
  i.setMinCgpa(body.getMinCgpa());
  i.setDescription(body.getDescription());
  i.setEligibleBranches(body.getEligibleBranches());
  i.setRequiredSkills(body.getRequiredSkills());

  return internships.save(i);
 }

 @DeleteMapping("/internships/{id}")
 @Transactional
 ResponseEntity<?> delete(@PathVariable Long id) {

  if (!internships.existsById(id)) {
   return ResponseEntity.notFound().build();
  }

  applicationRepository.deleteByInternship_Id(id);
  internships.deleteById(id);

  return ResponseEntity.noContent().build();
 }

 @GetMapping("/students")
 List<Student> students() {
  return students.findAll();
 }

 @GetMapping("/applications")
 List<Application> applications() {
  return apps.all();
 }

 @PutMapping("/applications/{id}/status")
 Application status(
         @PathVariable Long id,
         @Valid @RequestBody StatusRequest r) {
  return apps.status(id, r);
 }
}
