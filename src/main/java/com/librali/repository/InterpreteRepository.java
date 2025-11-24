package com.librali.repository;

import com.librali.model.Interprete;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterpreteRepository extends JpaRepository <Interprete, Integer> {
}
