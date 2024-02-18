package com.example.mentorscheduler.controllers;

import com.example.mentorscheduler.dtos.EditMentorDTO;
import com.example.mentorscheduler.dtos.GetMentorNameDTO;
import com.example.mentorscheduler.models.Mentor;
import com.example.mentorscheduler.services.GradeService;
import com.example.mentorscheduler.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MainRestController {
  private final MentorService mentorService;
  private final GradeService gradeService;

  @Autowired
  public MainRestController(MentorService mentorService, GradeService gradeService) {
    this.mentorService = mentorService;
    this.gradeService = gradeService;
  }

  @GetMapping("/mentors")
  public ResponseEntity classname(@RequestParam String className) {
    if (gradeService.gradeExistCheckByName(className)) {
      List<Mentor> mentors = gradeService.getGradeByName(className.toLowerCase()).getMentors();
      List<GetMentorNameDTO> onlyNames = mentors.stream().map(mentor -> new GetMentorNameDTO(mentor.getName())).collect(Collectors.toList());
      return ResponseEntity.status(200).body(onlyNames);
    } else {
      return ResponseEntity.status(400).build();
    }
  }

  @PutMapping("/mentors/{mentorId}")
  public ResponseEntity updateMentor(@PathVariable Long mentorId, @RequestBody EditMentorDTO editMentorDTO) {
    Optional<Mentor> foundMentor = mentorService.findMentorById(mentorId);
    if (!foundMentor.isPresent()) {
      return ResponseEntity.status(404).build();
    } else if (foundMentor.isPresent() && !editMentorDTO.getClassName().equals(gradeService.getGradeByName(editMentorDTO.getClassName()).getName())) {
      return ResponseEntity.status(400).build();
    } else {
      Mentor mentorFromDatabase = mentorService.getMentorById(mentorId);
      mentorFromDatabase.setName(editMentorDTO.getName());
      mentorFromDatabase.setGrade(gradeService.getGradeByName(editMentorDTO.getClassName()));
      mentorService.saveAndUpdate(mentorFromDatabase);
      return ResponseEntity.status(200).build();
    }
  }
}





