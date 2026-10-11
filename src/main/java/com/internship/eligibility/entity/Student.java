
        package com.internship.eligibility.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private String phone;
    private String branch;
    private Integer year;
    private Double cgpa;
    private String resumeLink;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "skill")
    private List<String> skills = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "student_certifications",
            joinColumns = @JoinColumn(name = "student_id")
    )
    @Column(name = "certification")
    private List<String> certifications = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return user.getName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User v) {
        user = v;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String v) {
        phone = v;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String v) {
        branch = v;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer v) {
        year = v;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double v) {
        cgpa = v;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String v) {
        resumeLink = v;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> v) {
        skills = v == null ? new ArrayList<>() : v;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> v) {
        certifications = v == null ? new ArrayList<>() : v;
    }
}

