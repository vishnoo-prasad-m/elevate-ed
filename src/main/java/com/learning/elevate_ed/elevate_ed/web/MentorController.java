package com.learning.elevate_ed.elevate_ed.web;

import com.learning.elevate_ed.elevate_ed.dto.User;
import com.learning.elevate_ed.elevate_ed.exception.ElevateEdException;
import com.learning.elevate_ed.elevate_ed.model.Mentor;
import com.learning.elevate_ed.elevate_ed.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @GetMapping("/{mentorId}")
    public Mentor getMentor(@PathVariable String mentorId) throws ElevateEdException {
        Mentor Mentor =  mentorService.getMentor(mentorId);
        if (Mentor == null) {
            throw new ElevateEdException("Mentor not found", HttpStatus.NOT_FOUND);
        }
        return Mentor;
    }

    @PostMapping
    public Mentor addMentor(@RequestBody Mentor Mentor) throws ElevateEdException {
       return mentorService.addMentor(Mentor);
    }

    @PostMapping("mentor-login")
    public Mentor validateLearner(@RequestBody User user) throws ElevateEdException {
        return mentorService.validateMentor(user);
    }

  @GetMapping("/skill/{skill}")
    public List<Mentor> getRecommendationsBySkill(@PathVariable String skill) {
        return mentorService.getMentorsBySkill(skill);
    }
}
