
package com.internship.eligibility.service;

import com.internship.eligibility.dto.StudentDto.*;
import com.internship.eligibility.entity.*;
import com.internship.eligibility.exception.ApiException;
import com.internship.eligibility.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class StudentService {
 private final UserRepository users;
 private final StudentRepository students;

 public StudentService(UserRepository u, StudentRepository s) {
  users = u;
  students = s;
 }

 @Transactional(readOnly = true)
 public Student get(String email) {
  User u = users.findByEmailIgnoreCase(email)
          .orElseThrow(() ->
                  new ApiException("User not found", HttpStatus.NOT_FOUND));

  return students.findByUser(u)
          .orElseThrow(() ->
                  new ApiException("Student profile not found", HttpStatus.NOT_FOUND));
 }

 @Transactional
 public Student update(String email, UpdateRequest r) {
  Student s = get(email);

  s.getUser().setName(r.name());
  users.save(s.getUser());

  s.setPhone(r.phone());
  s.setBranch(r.branch());
  s.setYear(r.year());
  s.setCgpa(r.cgpa());
  s.setSkills(r.skills());
  s.setCertifications(r.certifications());
  s.setResumeLink(r.resumeLink());

  return students.save(s);
 }
}