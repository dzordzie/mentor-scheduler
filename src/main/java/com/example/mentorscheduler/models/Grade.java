package com.example.mentorscheduler.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
  //@JsonManagedReference
  private List<Mentor> mentors;


  public Grade() {
  }

  public Grade(String name) {
    this.name = name;
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

  public List<Mentor> getMentors() {
    return mentors;
  }

  public void setMentors(List<Mentor> mentors) {
    this.mentors = mentors;
  }
}
