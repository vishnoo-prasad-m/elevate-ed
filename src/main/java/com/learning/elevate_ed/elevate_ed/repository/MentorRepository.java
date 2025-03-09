package com.learning.elevate_ed.elevate_ed.repository;

import com.learning.elevate_ed.elevate_ed.model.Learner;
import com.learning.elevate_ed.elevate_ed.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByUserId(String learner);
    List<Mentor> findBySkills_Name(String skill);
}
