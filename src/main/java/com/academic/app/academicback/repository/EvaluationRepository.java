package com.academic.app.academicback.repository;

import com.academic.app.academicback.entity.EvaluationEntity;
import com.academic.app.academicback.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EvaluationRepository extends JpaRepository<EvaluationEntity,Long> {

    public List<EvaluationEntity> findAllByName(String name);
}
