package com.learning.elevate_ed.elevate_ed.repository;

import com.learning.elevate_ed.elevate_ed.model.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
    Optional<Learner> findByUserId(String learner);
}
