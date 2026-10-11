package com.internship.eligibility.repository;
import com.internship.eligibility.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface StudentRepository extends JpaRepository<Student,Long>{Optional<Student> findByUser(User user);}
