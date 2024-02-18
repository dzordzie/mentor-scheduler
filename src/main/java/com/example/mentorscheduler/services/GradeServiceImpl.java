package com.example.mentorscheduler.services;

import com.example.mentorscheduler.models.Grade;
import com.example.mentorscheduler.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {
  private final GradeRepository gradeRepository;

  @Autowired
  public GradeServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }


  @Override
  public List<Grade> getGrades() {
    return gradeRepository.findAll();
  }

  @Override
  public void saveGrade(Grade grade) {
    gradeRepository.save(grade);
  }

  @Override
  public Grade getGradeByName(String name) {
    Optional<Grade> foundGrade = gradeRepository.findGradeByName(name);
    Grade g = new Grade();
    if (foundGrade.isPresent()) {
      g = foundGrade.get();
    }
    return g;
  }

  @Override
  public boolean gradeExistCheckByName(String className) {
    if (gradeRepository.findGradeByName(className).isPresent()) {
      return true;
    } else {
      return false;
    }
  }

}
