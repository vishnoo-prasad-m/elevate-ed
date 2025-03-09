package com.learning.elevate_ed.elevate_ed.web;

import com.learning.elevate_ed.elevate_ed.dto.User;
import com.learning.elevate_ed.elevate_ed.exception.ElevateEdException;
import com.learning.elevate_ed.elevate_ed.model.Learner;
import com.learning.elevate_ed.elevate_ed.service.LearnerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/learner")
public class LearnerController {

    @Autowired
    LearnerService learnerService;

    @GetMapping("/{learnerId}")
    public Learner getLearner(@PathVariable("learnerId")  String learnerId) throws ElevateEdException {
        Learner learner =  learnerService.getLearner(learnerId);
        if (learner == null) {
            throw new ElevateEdException("Learner not found", HttpStatus.NOT_FOUND);
        }
        return learner;
    }

    @PostMapping("/learner-login")
    public Learner validateLearner(@RequestBody User user) throws ElevateEdException {
        return learnerService.validateLearner(user);
    }

    @PostMapping
    public Learner addLearner(@RequestBody Learner learner) throws ElevateEdException {
       return learnerService.addLearner(learner);
    }
}
