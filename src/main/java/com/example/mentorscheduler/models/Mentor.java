package com.example.mentorscheduler.models;

import javax.persistence.*;

@Entity
public class Mentor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  @JoinColumn(name = "grade_id")
  //@JsonBackReference
  private Grade grade;


  public Mentor() {
  }

  public Mentor(String name, Grade grade) {
    this.name = name;
    this.grade = grade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }
}
