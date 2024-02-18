package com.example.mentorscheduler.dtos;

public class GetMentorNameDTO {
  private String name;

  public GetMentorNameDTO(String name) {
    this.name = name;
  }

  public GetMentorNameDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
