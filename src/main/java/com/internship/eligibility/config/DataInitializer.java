
package com.internship.eligibility.config;

import com.internship.eligibility.entity.*;
import com.internship.eligibility.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

 @Bean
 CommandLineRunner seedAdmin(
         UserRepository users,
         PasswordEncoder encoder) {

  return args -> {
   String email = "udaynakkanaboina338@gmail.com";
   String password = "1234567890";

   User u = users.findByEmailIgnoreCase(email)
           .orElseGet(User::new);

   u.setName("Admin");
   u.setEmail(email);
   u.setPassword(encoder.encode(password));
   u.setRole(Role.ADMIN);

   users.save(u);
  };
 }
}
