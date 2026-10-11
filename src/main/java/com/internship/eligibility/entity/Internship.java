
package com.internship.eligibility.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "internships")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String title;

    private String location;
    private String duration;
    private Double stipend;
    private Double minCgpa;

    @Column(length = 1000)
    private String description;

    @BatchSize(size = 50)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "internship_branches",
            joinColumns = @JoinColumn(name = "internship_id"))
    @Column(name = "branch")
    private List<String> eligibleBranches = new ArrayList<>();

    @BatchSize(size = 50)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "internship_required_skills",
            joinColumns = @JoinColumn(name = "internship_id"))
    @Column(name = "skill")
    private List<String> requiredSkills = new ArrayList<>();

    public Long getId() { return id; }

    public String getCompany() { return company; }
    public void setCompany(String v) { company = v; }

    public String getTitle() { return title; }
    public void setTitle(String v) { title = v; }

    public String getLocation() { return location; }
    public void setLocation(String v) { location = v; }

    public String getDuration() { return duration; }
    public void setDuration(String v) { duration = v; }

    public Double getStipend() { return stipend; }
    public void setStipend(Double v) { stipend = v; }

    public Double getMinCgpa() { return minCgpa; }
    public void setMinCgpa(Double v) { minCgpa = v; }

    public String getDescription() { return description; }
    public void setDescription(String v) { description = v; }

    public List<String> getEligibleBranches() {
        return eligibleBranches;
    }

    public void setEligibleBranches(List<String> v) {
        eligibleBranches = v == null ? new ArrayList<>() : v;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> v) {
        requiredSkills = v == null ? new ArrayList<>() : v;
    }
}
