package com.internship.eligibility.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty; import java.time.LocalDateTime;

@Entity @Table(name="applications", uniqueConstraints=@UniqueConstraint(columnNames={"student_id","internship_id"}))
public class Application {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) @JoinColumn(name="student_id") private Student student;
    @ManyToOne(optional=false) @JoinColumn(name="internship_id") private Internship internship;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private ApplicationStatus status=ApplicationStatus.APPLIED;
    @Column(nullable=false) private LocalDateTime appliedAt=LocalDateTime.now();
    public Long getId(){return id;} public Student getStudent(){return student;} public void setStudent(Student v){student=v;} public Internship getInternship(){return internship;} public void setInternship(Internship v){internship=v;}
    public ApplicationStatus getStatus(){return status;} public void setStatus(ApplicationStatus v){status=v;} @JsonProperty("appliedDate") public LocalDateTime getAppliedAt(){return appliedAt;}
}
