package com.example.mentorscheduler.repositories;

import com.example.mentorscheduler.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
  Optional<Mentor> findMentorByName(String name);

}
