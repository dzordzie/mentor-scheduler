package com.example.mentorscheduler.controllers;

import com.example.mentorscheduler.models.Mentor;
import com.example.mentorscheduler.services.GradeService;
import com.example.mentorscheduler.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private final MentorService mentorService;
  private final GradeService gradeService;

  @Autowired
  public MainController(MentorService mentorService, GradeService gradeService) {
    this.mentorService = mentorService;
    this.gradeService = gradeService;
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("mentors", mentorService.getAllMentors());
    model.addAttribute("grades", gradeService.getGrades());
    return "index";
  }


  @GetMapping("/mentor/{id}")
  public String mentorDetails(Model model, @PathVariable Long id) {
    if (!mentorService.mentorIdExistCheck(id)) {
      return "mentor-doesnt-exists";
    } else {
      model.addAttribute("mentor", mentorService.getMentorById(id));
      return "detail";
    }
  }


  @PostMapping("/mentor")
  public String saveMentor(@RequestParam String name, @RequestParam String grade) {
    if (mentorService.mentorExistCheck(name)) {
      return "mentor-already-exists";
    } else {
      Mentor newMentor = mentorService.saveNewMentor(new Mentor(name, gradeService.getGradeByName(grade)));
      return "redirect:/mentor/" + newMentor.getId();
    }
  }


}
