
package com.internship.eligibility.repository;

import com.internship.eligibility.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    List<Application> findByStudentOrderByAppliedAtDesc(
            Student student);

    boolean existsByStudentAndInternship(
            Student s, Internship i);

    boolean existsByInternship_Id(Long internshipId);

    List<Application> findAllByOrderByAppliedAtDesc();

    void deleteByInternship_Id(Long internshipId);
}
