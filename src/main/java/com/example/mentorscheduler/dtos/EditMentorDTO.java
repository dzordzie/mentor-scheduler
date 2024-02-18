package com.example.mentorscheduler.dtos;

public class EditMentorDTO {
  private String name;
  private String className;

  public EditMentorDTO() {
  }

  public EditMentorDTO(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }
}
