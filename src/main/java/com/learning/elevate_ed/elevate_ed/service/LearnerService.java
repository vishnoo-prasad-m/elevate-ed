package com.learning.elevate_ed.elevate_ed.service;

import com.learning.elevate_ed.elevate_ed.dto.User;
import com.learning.elevate_ed.elevate_ed.exception.ElevateEdException;
import com.learning.elevate_ed.elevate_ed.model.Learner;
import com.learning.elevate_ed.elevate_ed.repository.LearnerRepository;
import com.learning.elevate_ed.elevate_ed.utils.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    LearnerRepository learnerRepository;

    public Learner getLearner(String learnerId) {
        Optional<Learner> learnerOptional = learnerRepository.findByUserId(learnerId);
        return learnerOptional.orElse(null);
    }

    public Learner addLearner(Learner learner) throws ElevateEdException {
         Optional<Learner> learnerOptional = learnerRepository.findByUserId(learner.getUserId());
        if (learnerOptional.isEmpty()) {
            learner.setPassword(PasswordEncryptor.encryptPassword(learner.getPassword()));
            return learnerRepository.save(learner);
        }
        throw new ElevateEdException("UserID already exists", HttpStatus.CONFLICT);
    }

    public Learner updateLearner(Learner learner) {
        return learnerRepository.save(learner);
    }

    public Learner validateLearner(User user) throws ElevateEdException {
        Optional<Learner> learner = learnerRepository.findByUserId(user.getUserId());
        if (learner.isEmpty()) {
            throw new ElevateEdException("No learner found with UserId", HttpStatus.NOT_FOUND);
        }
        if(PasswordEncryptor.checkPassword(user.getPassword(), learner.get().getPassword())) {
            return learner.get();
        }
        throw new ElevateEdException("Password incorrect", HttpStatus.BAD_REQUEST);
    }
}
