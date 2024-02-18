package com.example.mentorscheduler.repositories;

import com.example.mentorscheduler.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
  Optional<Grade> findGradeByName(String name);

}
