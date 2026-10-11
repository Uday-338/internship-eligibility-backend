package com.internship.eligibility.repository;
import com.internship.eligibility.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long>{Optional<User> findByEmailIgnoreCase(String email);}
