package com.example.mentorscheduler.services;

import com.example.mentorscheduler.models.Mentor;
import com.example.mentorscheduler.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {
  private final MentorRepository mentorRepository;

  @Autowired
  public MentorServiceImpl(MentorRepository mentorRepository) {
    this.mentorRepository = mentorRepository;
  }

  @Override
  public List<Mentor> getAllMentors() {
    return mentorRepository.findAll();
  }

  @Override
  public Mentor saveNewMentor(Mentor mentor) {
    return mentorRepository.save(mentor);
  }

  @Override
  public void saveAndUpdate(Mentor mentor) {
    mentorRepository.save(mentor);
  }


  @Override
  public boolean mentorExistCheck(String name) {
    Optional<Mentor> foundMentor = mentorRepository.findMentorByName(name);
    if (foundMentor.isPresent()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Mentor getMentorById(Long id) {
    Optional<Mentor> foundMentor = mentorRepository.findById(id);
    Mentor m = new Mentor();
    if (foundMentor.isPresent()) {
      m = foundMentor.get();
    }
    return m;
  }

  @Override
  public Optional<Mentor> findMentorById(Long id) {
    return mentorRepository.findById(id);
  }

  @Override
  public boolean mentorIdExistCheck(Long id) {
    Optional<Mentor> foundMentor = mentorRepository.findById(id);
    return foundMentor.isPresent();
  }

}
