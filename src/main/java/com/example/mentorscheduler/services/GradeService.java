package com.example.mentorscheduler.services;

import com.example.mentorscheduler.models.Grade;

import java.util.List;

public interface GradeService {
  List<Grade> getGrades();

  void saveGrade(Grade grade);

  Grade getGradeByName(String name);

  boolean gradeExistCheckByName(String className);
}
