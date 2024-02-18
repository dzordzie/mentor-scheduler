package com.example.mentorscheduler.services;

import com.example.mentorscheduler.models.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {

  List<Mentor> getAllMentors();

  Mentor saveNewMentor(Mentor mentor);

  void saveAndUpdate(Mentor mentor);

  boolean mentorExistCheck(String name);

  Mentor getMentorById(Long id);

  Optional<Mentor> findMentorById(Long id);

  boolean mentorIdExistCheck(Long id);

}
