package com.learning.elevate_ed.elevate_ed.service;

import com.learning.elevate_ed.elevate_ed.dto.User;
import com.learning.elevate_ed.elevate_ed.exception.ElevateEdException;
import com.learning.elevate_ed.elevate_ed.model.Mentor;
import com.learning.elevate_ed.elevate_ed.repository.MentorRepository;
import com.learning.elevate_ed.elevate_ed.utils.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    MentorRepository mentorRepository;

    public Mentor getMentor(String mentorId) {
        Optional<Mentor> mentorOptional = mentorRepository.findByUserId(mentorId);
        return mentorOptional.orElse(null);
    }

    public Mentor addMentor(Mentor mentor) throws ElevateEdException {
         Optional<Mentor> mentorOptional = mentorRepository.findByUserId(mentor.getUserId());
         if (mentorOptional.isEmpty()) {
            mentor.setPassword(PasswordEncryptor.encryptPassword(mentor.getPassword()));
            return mentorRepository.save(mentor);
        }
        throw new ElevateEdException("UserID already exists", HttpStatus.CONFLICT);
    }


    public List<Mentor> getMentorsBySkill(String skill) {
        return mentorRepository.findBySkills_Name(skill);
    }

    public Mentor validateMentor(User user) throws ElevateEdException {
        Optional<Mentor> mentor = mentorRepository.findByUserId(user.getUserId());
        if (mentor.isEmpty()) {
            throw new ElevateEdException("No mentor found with UserId", HttpStatus.NOT_FOUND);
        }
        if (PasswordEncryptor.checkPassword(user.getPassword(), mentor.get().getPassword())) {
            return mentor.get();
        };
        throw new ElevateEdException("Password incorrect", HttpStatus.BAD_REQUEST);
    }
}
